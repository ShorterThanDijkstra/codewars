(defn sum-consecutives [a]
  (if (empty? a) []
      (loop [pre (first a),
             rst (rest a),
             acc pre,
             res []]
        (cond (empty? rst)  (conj res acc)
              (= pre (first rst)) (recur pre (rest rst) (+ acc pre) res)
              :else (recur (first rst) (rest rst) (first rst) (conj res acc))))))

;; (load-file "sum_consecutives.clj")