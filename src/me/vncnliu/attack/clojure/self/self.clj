(ns me.vncnliu.attack.clojure.self.self)

(defn factorial [n]
  (if (= 1 n)
    (/ 1 100)
    (* (/ n 100) (factorial (dec n)))))

(defn temp-array [n]
    (if (= 1 n)
    [1]
    (conj (temp-array (dec n)) n)))

(defn length [coll]
  (if (empty? coll)
    0
    (+ 1 (length (rest coll)))))

(defn get-array [n]
  (int-array (temp-array n)))

(defn swap [array index1 index2]
  (let [temp (aget array index1)]
  (aset array index1 (aget array index2))
  (aset array index2 temp)))

(defn rand-part-array [array part-array partln swapln]
  (let [temp (rand-int swapln)]
    (conj part-array (aget array temp))
    (swap array temp swapln)
    (if (= partln (length part-array))
      part-array
      (rand-part-array array part-array partln (dec swapln)))))

(defn rand_part [array partln part-array]
  (if (= (count part-array) (+ partln (count part-array)) )
    part-array
    (if (< (rand) (/ partln (count array)))
      (rand_part (rest array) (dec partln) (conj part-array (first array)))
      (rand_part (rest array) partln part-array))))

(use 'clojure.java.io)

(defn get_str [n]
  (if (< n 1)
    ()
    (conj (get_str (dec n)) (rand_part (list 1 2 3 4 5 6) 3 ()))))

(dotimes [n 10000] (with-open [wrtr (writer "a.txt":append true)]
                     (.write wrtr (prn-str (rand_part (list 1 2 3 4) 3 ())))))

;(dotimes [n 5] (println (rand_part (list 1 2 3 4 5 6) 3 ())))