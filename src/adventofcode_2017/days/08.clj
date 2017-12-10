(ns adventofcode-2017.days.08
  (:require
   [clojure.string :as str]
   [adventofcode-2017.utils :as utils]))


(def example "b inc 5 if a > 1
a inc 1 if b < 5
c dec -10 if a >= 1
c inc -20 if c == 10")

(def registers (atom {}))


(defn update!
  [target value op]
  (swap! registers assoc
         (keyword target)
         (op (or ((keyword target) @registers) 0) (Integer/parseInt value))))

(defn translate-operation
  [op]
  (cond
    (= op "==") "="
    (= op "!=") "not="
    :default op))

(defn update-register
  [instruction]
  (let [[target op n condition a cond-op b] (str/split instruction #" ")
        val-one (or ((keyword a) @registers) 0)
        form (str "(" condition "(" (translate-operation cond-op) " "  val-one " " b ") " "true false)")
        predicate (eval (read-string form))]
    (when predicate
      (case op
        "inc" (update! target n +)
        "dec" (update! target n -)))))


(defn main
  []
  (doseq [instruction (-> (utils/read-input "08") str/split-lines)]
    (update-register instruction))
  (apply max (vals @registers))) ;; => 4567
