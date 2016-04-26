import java.awt.Graphics;
import java.awt.Color;

/**
 * Created by Arie on 16-3-2016.
 */
public class HUD {

    public static int HEALTH = 100;
    private int greenValue = 255;

    private int score = 0;
    private int level = 1;


    public void tick(){
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);

        greenValue = HEALTH*2;

        score++;

    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(10, 10, 300, 16);
        g.setColor(new Color(75, greenValue, 0));
        //g.setColor(Color.green);
        g.fillRect(10, 10, HEALTH * 3, 16);
        g.setColor(Color.white);
        g.drawRect(10, 10, 300, 16);

        g.drawString("Score: " + score, 10, 44);
        g.drawString("Level: " + level, 10, 56);
    }

    public void score(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
}
