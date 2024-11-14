
public class TennisGame1 implements TennisGame {

    private int p1_score = 0;
    private int p2_score = 0;
    private final String player1Name;
    private final String player2Name;

    // Class constructor
    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    // Point set method
    public void addPoint(String playerName) {
        if (playerName.equals(player1Name))
            p1_score += 1;
        else
            p2_score += 1;
    }

    // Point get method
    public String getScoreString() {
        StringBuilder score;
        if (p1_score == p2_score) {
            score = getScoreParity();
        } else if (p1_score >= 4 || p2_score >= 4) {
            int minusResult = p1_score - p2_score;
            score = getScoreWin(minusResult);
        } else {
            score = getScoreNormalCase();
        }
        return score.toString();
    }

    private StringBuilder getScoreWin(int minusResult) {
        StringBuilder score;
        score = new StringBuilder(switch (minusResult) {
            case 1 -> "Advantage ".concat(player1Name);
            case -1 -> "Advantage ".concat(player2Name);
            default -> {
                if (minusResult >= 2) yield "Win for ".concat(player1Name);
                else yield "Win for ".concat(player2Name);
            }
        });
        return score;
    }

    private StringBuilder getScoreParity() {
        StringBuilder score;
        score = new StringBuilder(switch (p1_score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        });
        return score;
    }

    private StringBuilder getScoreNormalCase() {
        StringBuilder score = new StringBuilder();
        getPlayerScoreAndAppend(score, p1_score);
        score.append("-");
        getPlayerScoreAndAppend(score, p2_score);
        return score;
    }

    private static void getPlayerScoreAndAppend(StringBuilder score, int tempScore) {
        switch (tempScore) {
            case 0 -> score.append("Love");
            case 1 -> score.append("Fifteen");
            case 2 -> score.append("Thirty");
            case 3 -> score.append("Forty");
        }
    }
}
