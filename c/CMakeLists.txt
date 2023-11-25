cmake_minimum_required(VERSION 3.24)
project(c C)

set(CMAKE_C_STANDARD 11)
add_executable(c playground.c adding_big_numbers.c)
target_link_libraries(c m)

