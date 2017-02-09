(ns me.vncnliu.attack.clojure.sicp.C2-2-1)

;E2.17
(defn last-pair [iterms]
  (if (nil? (seq iterms))
    (throw (NullPointerException. "iterms is null"))
    (if (nil? (next iterms))
      iterms
      (last-pair (rest iterms))
      )
    ))

;E2.18
(defn scale-list [items factor]
        (if (empty? items)
          nil
          (cons (* (first items) factor)
                (scale-list (next items)
                            factor))))

