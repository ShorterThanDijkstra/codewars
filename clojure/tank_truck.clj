;; https://www.codewars.com/kata/55f3da49e83ca1ddae0000ad
(ns voltank.core)

(defn tank-vol [h d vt]
  (let [r (/ d 2), 
        cos-theta (/ (- r h) r), 
        theta (Math/acos cos-theta),
        ;; vol-total (* Math/PI (* r r) vt),
        area-fan (* Math/PI r r (/ theta Math/PI)),
        area-tri (* (- r h) (* r (Math/sin theta))),
        vol-fan (* vt (/ theta Math/PI)),
        vol-tri (* vol-fan (/ area-tri area-fan))]
    (long (- vol-fan vol-tri))))

