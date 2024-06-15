package com.zhao.demo.App;

public class scoreEstimate {
    // 分數:一次消除0行,1行,2行,3行,4行獲得分數
    private int[] scoresPoolSpeed1 = {0, 100, 300, 600, 1000};
    private int[] scoresPoolSpeed2 = {0, 200, 500, 800, 1500};
    private int[] scoresPoolSpeed3 = {0, 300, 800, 1300, 2000};
    private int scorePoolLength = scoresPoolSpeed1.length;
    //下落速度
    private int speed = 600;
    // 目前總分
    private int totalScore = 0;
    // 消除過的總行數
    private int totalLine = 0;

    private Timer gameTimer = new Timer();

    // get目前總分
    public int getTotalScore() {
        return totalScore;
    }

    // get目前消除過的總行數
    public int getTotalLine() {
        return totalLine;
    }

    public int getSpeed(){
        return speed;
    }

    // 重新開始
    public void resetScore() {
        totalScore = 0;
        totalLine = 0;
    }
    // 更新分數
    public void updateScore(int lines, int mode) {
        //bonus
        if(lines >= 1){
            if((gameTimer.getTime() / 1000 < 10) && (totalScore > 0)){
                totalScore = totalScore + (10-(int)(gameTimer.getTime()/1000))*60;
            }
            else if((gameTimer.getTime() / 1000 < 20) && (totalScore > 0)){
                totalScore = totalScore + (20-(int)(gameTimer.getTime()/1000))*16;
            }
            else if((gameTimer.getTime() / 1000 < 30) && (totalScore > 0)){
                totalScore = totalScore + (30-(int)(gameTimer.getTime()/1000))*5;
            }
            gameTimer.reset();
            gameTimer.startTimer();
        }

        if(mode == 0){//正常模式
            if (lines >= 0 && lines < scorePoolLength) {
                if((totalScore < 500)){
                    totalScore += scoresPoolSpeed1[lines];
                    totalLine += lines;
                    speed = 600-totalScore/6;
                }
                else if((totalScore >= 500 && totalScore<2000)){
                    totalScore += scoresPoolSpeed2[lines];
                    totalLine += lines;
                    speed = 550 - totalScore/8;
                }
                else if((totalScore >= 2000)){
                    totalScore += scoresPoolSpeed3[lines];
                    totalLine += lines;
                    speed = 550 - totalScore/10;
                    if(speed <= 250){
                        speed = 250;
                    }
                }
            }
        }
        else if(mode == 1){//扣分模式
            if(totalScore > 0){
                totalScore = totalScore - 2;
            }
            if (lines >= 0 && lines < scorePoolLength) {
                if(totalScore > 0 && lines > 0){
                    totalScore = totalScore + 2;
                }

                if((totalScore < 500)){
                    totalScore += scoresPoolSpeed1[lines];
                    totalLine += lines;
                    speed = 600 - totalScore/6;
                }
                else if((totalScore >= 500 && totalScore < 1500)){
                    totalScore += scoresPoolSpeed2[lines];
                    totalLine += lines;
                    speed = 500 - totalScore/8;
                }
                else if((totalScore >= 1500)){
                    totalScore += scoresPoolSpeed3[lines];
                    totalLine += lines;
                    speed = 450-totalScore/10;
                    if(speed<=200){
                        speed = 200;
                    }
                }
            }
        }
        else if(mode==2){//隨機速度模式
            speed = (int)(Math.random()*(500 - 200 + 1)) + 200;
            if (lines >= 0 && lines < scorePoolLength) {
                if((speed >= 300)){
                    totalScore += scoresPoolSpeed1[lines];
                    totalLine += lines;
                }
                else if(speed >= 250 && speed < 300){
                    totalScore += scoresPoolSpeed2[lines];
                    totalLine += lines;
                }
                else if(speed < 250){
                    totalScore += scoresPoolSpeed3[lines];
                    totalLine += lines;
                }
            }
        }
    }
}
