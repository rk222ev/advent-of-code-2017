(ns adventofcode-2017.days.three)


(defn find-layer-coord
  [n layer row-size]
  (let [min (-  (* row-size 4) 5)
        max (* row-size row-size)
        row-middle-index (/ row-size  2)]
    (reduce + [layer (->> (range (- (Math/floor row-middle-index)) (- row-middle-index 1))
                          (map #(.intValue %))
                          (map #(Math/abs %))
                          cycle
                          (drop 1)
                          (map vector (range (- max min) (+ 1 max)))
                          (filter #(= (first %) n))
                          first
                          second)])))


(defn calculate-distance-for
  ([n]
   (calculate-distance-for n 0 1))
  ([n layer row-size]
   (if (> n (* row-size row-size))
     (calculate-distance-for n (+ layer 1) (+ row-size 2))
     (find-layer-coord n layer row-size))))


(defn run
  [n]
   (calculate-distance-for 289326))


(defn main
  []
  (let [input 289326]
    {:part-1 (run input)
     :part-2 nil}))
