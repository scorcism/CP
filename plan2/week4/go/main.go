package main

import (
	"math"
)

func getMax(piles []int) int {
	var maxCount = math.MinInt
	for i := 0; i < len(piles); i++ {
		if maxCount < piles[i] {
			maxCount = piles[i]
		}
	}

	return maxCount
}

func isValid(k int, piles []int, hours int) bool {
	var h = 0

	for i := 0; i < len(piles); i++ {
		h += (piles[i] + k - 1) / k
	}
	return h <= hours
}

func minEatingSpeed(piles []int, h int) int {

	var min = 1
	var max = getMax(piles)

	res := -1
	for min <= max {
		var mid = min + (max-min)/2

		if isValid(mid, piles, h) {
			res = mid
			max = mid - 1
		} else {
			min = mid + 1
		}
	}

	return res
}
