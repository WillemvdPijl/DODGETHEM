import java.awt.*;

/**
 * Created by Arie on 26-4-2016.
 */
public class FastEnemy2 extends GameObject {

    private Handler handler;

    public FastEnemy2(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 9;
        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        if(y < 0 || y >= Game.HEIGHT -32) velY *= -1;
        if(x < 0 || x >= Game.WIDTH -16) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.cyan);
        g.fillRect(x, y, 16, 16);

    }
}