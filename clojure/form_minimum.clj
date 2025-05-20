(ns kata)
(defn min-value [digits]
   (let [digits' (sort (set digits))]
      (reduce #(+ (* %1 10) %2) 0 digits')))
