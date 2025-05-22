;; (ns string-rotation)

(defn shifted-diff [fst snd]
  (let [n (count fst)]
  (loop [i n]
    (if (zero? i)
         -1
        (let [left (subs fst 0 i), right (subs fst i n)]
          (if (= (str right left) snd)
              (- n i)
              (recur (dec i))))))))
