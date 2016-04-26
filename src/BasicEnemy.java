import java.awt.*;

/**
 * Created by Arie on 16-3-2016.
 */
public class BasicEnemy extends GameObject {

    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 5;
        velY = 5;
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

        handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.07f, handler));
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);

    }
}
