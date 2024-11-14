
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;

    // Class constructor
    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    // Point set method
    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    // Point get method
    public String getScore() {
        StringBuilder score = new StringBuilder();
        int tempScore = 0;
        if (m_score1 == m_score2) {
            score = getParityScore();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            score = getWinningScore(minusResult);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = m_score1;
                else {
                    score.append("-");
                    tempScore = m_score2;
                }
                switch (tempScore) {
                    case 0:
                        score.append("Love");
                        break;
                    case 1:
                        score.append("Fifteen");
                        break;
                    case 2:
                        score.append("Thirty");
                        break;
                    case 3:
                        score.append("Forty");
                        break;
                }
            }
        }
        return score.toString();
    }

    private StringBuilder getWinningScore(int minusResult) {
        StringBuilder score;
        if (minusResult == 1) score = new StringBuilder("Advantage ".concat(player1Name));
        else if (minusResult == -1) score = new StringBuilder("Advantage ".concat(player2Name));
        else if (minusResult >= 2) score = new StringBuilder("Win for ".concat(player1Name));
        else score = new StringBuilder("Win for ".concat(player2Name));
        return score;
    }

    private StringBuilder getParityScore() {
        StringBuilder score;
        score = new StringBuilder(switch (m_score1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        });
        return score;
    }
}
