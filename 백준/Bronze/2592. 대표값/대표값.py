nums = [int(input()) for _ in range(10)]
print(sum(nums) //10)
print(sorted(nums, key=lambda x : nums.count(x))[-1])