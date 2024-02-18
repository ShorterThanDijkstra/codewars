# https://www.codewars.com/kata/52b5247074ea613a09000164/train/riscv
.global cooktime

# <-- A0 unsigned cooktime(A0 unsigned eggs) -->
cooktime:
    beqz a0, exit
    addi a0, a0, -1
    srliw a0, a0, 3
    addi a0, a0, 1
    sh2add a0, a0, a0
exit:
    ret
