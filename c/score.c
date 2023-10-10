int score(const int dice[5]) {
    int counts[7] = {0};
    for (int i = 0; i < 5; ++i) {
        counts[dice[i]] += 1;
    }
    int score = 0;
    for (int i = 1; i <= 6; ++i) {
        if (counts[i] >= 3) {
            score += i == 1 ? 1000 : i * 100;
            counts[i] -= 3;
        }
    }
    score = score + counts[1] * 100;
    score = score + counts[5] * 50;
    return score;
}
int main() {
    int dice[] = {1,1,1,3,1};
    int the_score = score(dice);
}