(ns me.vncnliu.attack.clojure.sicp.C2-1-3)
;E2-5
(defn pow [a n]
  (if (= n 0)
    1
    (* a (pow a (dec n)))))

(defn factor [x y n]
  (if (= (rem x y) 0)
    (factor (/ x y) y (inc n))
    n))

(defn cons_self [a b] (* (pow 2 a) (pow 3 b)))

(defn car [x] (factor x 2 0))

(defn cdr [x] (factor x 3 0))

