(ns findeven.core)

(defn help [arr left right i]
  (if (>= i (count arr))
      -1
      (let [curr (get arr i)]
             (if (= left (- right curr))
                 i
                 (help arr (+ left curr) (- right curr) (inc i))))))

(defn find-even-index [arr]
   (let [sum (apply + arr)]
     (help arr 0 sum 0)))

;; test
(def v1 [1,2,3,4,3,2,1])
(def v2 [1,100,50,-51,1,1])
(def v3 [1,2,3,4,5,6])
(def v4 [20,10,30,10,10,15,35])
(def f find-even-index)
