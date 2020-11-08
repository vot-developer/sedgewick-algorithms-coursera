**Egg drop.** 

Suppose that you have an nn-story building (with floors 1 through nn) and plenty of eggs. An egg breaks if it is dropped from floor **T** or higher and does not break otherwise. Your goal is to devise a strategy to determine the value of **T** given the following limitations on the number of eggs and tosses:
* Version 0: 1 egg, ≤ T tosses.
* Version 1: ~ 1 lg n eggs and ~1 lg n tosses.
* Version 2: ∼ lg T eggs and ~ 2 lg T tosses.
* Version 3: 2 eggs and ~ 2 n^1/2 tosses.
* Version 4: 2 eggs and ≤ c T^1/2 tosses for some fixed constant cc.

_Hints:_ 
* Version 0: sequential search.
* Version 1: binary search.
* Version 2: find an interval containing T of size ≤ 2T, then do binary search.
* Version 3: find an interval of size n^1/2, then do sequential search. Note: can be improved to ~ {2n}^1/2 tosses.
* Version 4: 1 + 2 + 3 + ... + t ~ 1/2 t^2. Aim for c = 2 * 2^1/2.


