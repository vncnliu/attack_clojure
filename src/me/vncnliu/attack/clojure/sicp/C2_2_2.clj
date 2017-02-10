(ns me.vncnliu.attack.clojure.sicp.C2-2-2)

;E2.18
(defn my_reverse [x,r]
    (if (empty? x)
      r
      (my_reverse (rest x) (conj r (first x)))))

;E2.27
(defn deep_reverse [x]
  z)