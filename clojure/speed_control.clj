;; https://www.codewars.com/kata/56484848ba95170a8000004d/train/clojure

;; (ns gps.core)

(defn help [x pre max']
  (if (empty? x)
    max'
    (let [diff (- (first x) pre)]
      (let
       [max'' (max max' diff)]
        (help (rest x) (first x) max'')))))

(defn gps [s x]
  (do
    (println x)
    (if (< (count x) 2)
      0
      (let [max' (help (rest x) (first x) 0)]
        (int (/ (* 3600 max') s))))))

(def x [0.0, 0.19, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0, 2.25])