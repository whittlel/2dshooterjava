import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {

	private Handler handler;
	
	public Bullet(int x, int y, ID id, Handler handler, int mx, int my) {
		super(x, y, id);
		this.handler = handler;
		
		velX = (mx - x) / 10; //the problem with this shooting algorithm is that it depends where you click on how hard the bullet goes
		velY = (my - y) / 10; //could use this algorithm to do damage, slower more damage faster less damage (for skill cap)
	}

	public void tick() {
		x += velX;
		y += velY;
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Block){
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(this);
				}
			}
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x, y, 8, 8);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

}
