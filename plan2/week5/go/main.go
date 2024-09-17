package main

func findMin(nums []int) int {

	start := 0
	end := len(nums) - 1

	for start < end {
		mid := start + (end-start)/2

		if nums[mid] > nums[end] {
			start = mid + 1
		} else {
			end = mid
		}
	}

	return nums[start]
} 
