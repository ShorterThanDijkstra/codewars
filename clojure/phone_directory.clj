;; https://www.codewars.com/kata/56baeae7022c16dd7400086e/train/clojure
(defn parse-phone [line] ())

(defn parse-line [line] ())

(defn res-str [res] ())

(defn phone [strng num]
  (let [lines (clojure.string/split-lines strng)]
    (loop [lines lines, res false]
      (if (empty? lines)
          (if res (res-str res) (str "Error => Not found: " num))
          (let [parsed (parse-line (first lines)),
                phone (parsed :phone)]
            (if (= phone num)
                (if-not res 
                        "Error => Too many people: num" 
                        (recur (rest lines) res))
                (recur (rest lines) res)))))))


    