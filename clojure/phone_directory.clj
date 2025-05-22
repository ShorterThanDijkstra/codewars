;; https://www.codewars.com/kata/56baeae7022c16dd7400086e/train/clojure

(ns phonedir.core)

(def PHONE_PATTERN #"\+(\d{1,2}-\d{3}-\d{3}-\d{4})")

(def NAME_PATTERN #"<([^>]+)>")

(defn parse-phone [line] 
  (let [matches (re-seq PHONE_PATTERN line)]
      (do (assert (= (count matches) 1))
          (second (first matches)))))

(defn parse-name [line]
  (let [matches (re-seq NAME_PATTERN line)]
    (do (assert (= (count matches) 1))
        (second (first matches)))))

(defn parse-address [line]
  (let [r clojure.string/replace,
        t clojure.string/trim,
        s clojure.string/split,
        j clojure.string/join,
        line' (-> line
                  (r PHONE_PATTERN "")
                  (r NAME_PATTERN "")),
        ;; line' (r (r line PHONE_PATTERN "") NAME_PATTERN ""),
        words (-> line'
            (r #"[^a-zA-Z0-9.-]" " ")
            (s #"\s+"))]
      (->> words 
          (j " ")
          (t))))

(defn parse-line [line]
  (let [phone (parse-phone line),
        name (parse-name line),
        address (parse-address line)]
    {:phone phone, :name name, :address address}))

(defn res-str [res] 
  (str "Phone => " (res :phone) ", Name => " (res :name) ", Address => " (res :address)))

(defn phone [strng num]
  (let [lines (clojure.string/split-lines strng)]
    (loop [lines lines, res false]
      (if (empty? lines)
        (if res (res-str res) (str "Error => Not found: " num))
        (let [parsed (parse-line (first lines)),
              phone (parsed :phone)]
          (if (= phone num)
            (if res
                (str "Error => Too many people: " num)
                (recur (rest lines) parsed))
            (recur (rest lines) res)))))))

(def s "/+1-541-754-3010 156 Alphand_St. <J Steeve>")

;; (load-file "phone_directory.clj")
;; (in-ns 'phonedir.core)
