(ns sumdivsq.core)

(defn divisors [n]
  (loop [i 1 res []]
    (cond (= i n) (conj res i)
          (zero? (mod n i)) (recur (inc i) (conj res i))
          :else (recur (inc i) res))))

(defn squares-num? [n]
  (let [sqrt (int (Math/sqrt n))]
    (= (* sqrt sqrt) n)))

(defn list-squared [m n]
  (loop [i m res []]
    (if (> i n) res
        (let [squares (map #(* % %) (divisors i))
              sum-squares (apply + squares)]
          (if (squares-num? sum-squares)
            (recur (inc i) (conj res [i sum-squares]))
            (recur (inc i) res))))))

