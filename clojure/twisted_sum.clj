(ns twisted-sum)

(defn sum-digits [n]
  (if (< n 10) n
      (+ (rem n 10) (sum-digits (quot n 10)))))

(defn compute-sum [n]
  (loop [i n, sum 0]
     (if (= 1 i) (+ sum i)
         (recur (dec i) (+ (sum-digits i) sum)))))
  