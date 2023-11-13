void twoSum(unsigned count, const int numbers[count], int target,
            unsigned *index1, unsigned *index2)
{
    for (size_t i = 0; i < count; i++)
    {
        for (size_t j = i + 1; j < count; j++)
        {
            if (numbers[i] + numbers[j] == target)
            {
                *index1 = i;
                *index2 = j;
                return;
            }
        }
    }
}