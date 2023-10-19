cmake_minimum_required(VERSION 3.24)
project(c C)

set(CMAKE_C_STANDARD 11)
add_executable(c playing-with-digits.c is_a_number_prime.c maskify.c isograms.c make_the_deadfish_swim.c primes-in-numbers.c playground.c tribonacci_sequence.c camel_case.c alphanumeric.c score.c decode_the_morse_code.c number_of_trailing_zeros_of_n.c string_incrementer.c directions_reduction.c)
target_link_libraries(c m)

