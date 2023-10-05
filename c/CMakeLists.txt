cmake_minimum_required(VERSION 3.24)
project(c C)

set(CMAKE_C_STANDARD 11)
add_executable(c playing-with-digits.c is_a_number_prime.c maskify.c isograms.c make_the_deadfish_swim.c primes-in-numbers.c)
target_link_libraries(c m)

