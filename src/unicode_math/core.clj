(ns unicode-math.core
  (:require [clojure.set :as set]))

(def ½ 1/2)
(def ¼ 1/4)
(def ¾ 3/4)
(def ⅓ 1/3)
(def ⅔ 2/3)
(def ⅕ 1/5)
(def ⅖ 2/5)
(def ⅗ 3/5)
(def ⅘ 4/5)
(def ⅙ 1/6)
(def ⅚ 5/6)
(def ⅛ 1/8)
(def ⅜ 3/8)
(def ⅝ 5/8)
(def ⅞ 7/8)

(def ⌈ #(Math/ceil %))
(def ⌊ #(Math/floor %))
(def | #(Math/abs %))
 
(def ≤ <=)
(def ≥ >=)
(def ≠ not=)
(defn ≈ 
  ([x y ε]
    (≤ (| (- x y)) ε))
  ([x y]
    (≈ x y 1e-9)))

;; Please don't use these
(def − -)
(def ÷ /)
(def ∕ /)
(def × *)

(def ⁿ #(Math/pow %1 %2))
(def ¹ identity)
(def ² #(ⁿ % 2))
(def ³ #(ⁿ % 3))
(def √ #(Math/sqrt %))
(def ∛ #(ⁿ % ⅓))
(def ∜ #(ⁿ % ¼))


(def π Math/PI)
(def φ (/ (+ 1 (√ 5)) 2))
(def e Math/E)
(def ∞ Double/POSITIVE_INFINITY)

(def Π (partial apply *))
(def Σ (partial apply +))

(def ‰ #(/ 1000))
(def ‱ #(/ 10000))

(def ¬ not)
(defmacro ∧ [& xs] `(and ~@xs))
(defmacro ∨ [& xs] `(or ~@xs))
(defmacro ⊽ [& xs] `(¬ (∨ ~@xs)))
(defmacro ⊼ [& xs] `(¬ (∧ ~@xs)))
(defmacro ∀ [binding & exprs]
  `(every? identity (for ~binding ~@exprs)))
(defmacro ∃ [binding & exprs]
  `(if (some identity (for ~binding ~@exprs)) true false))()
(defmacro ∄ [binding & exprs]
  `(if (some identity (for ~binding ~@exprs)) false true))

(def ∩ set/intersection)
(def ∪ set/union)
(def ∋ contains?)
(defn ∈ [element coll] (contains? coll element))
(def ∉ (complement ∈))
(def ∌ (complement ∋))
(def ∖ set/difference)
(def ⊂ set/subset?)
(def ⊃ set/superset?)
(def ⊄ (complement ⊂))
(def ⊅ (complement ⊃))
