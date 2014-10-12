package com.mx262cal726.Dodge.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.mx262cal726.Dodge.framework.KeyInput;
import com.mx262cal726.Dodge.framework.ObjectId;
import com.mx262cal726.Dodge.framework.Texture;
import com.mx262cal726.Dodge.objects.Ball;
import com.mx262cal726.Dodge.objects.Block;
import com.mx262cal726.Dodge.objects.Enemy;
import com.mx262cal726.Dodge.objects.Flag;
import com.mx262cal726.Dodge.objects.Player;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = -4194662314807488855L;
    private boolean running =false;
    private Thread thread;
    public static int WIDTH, HEIGHT;
    private int numBuffer =3;
    public static int LEVEL =1;
    
    public BufferedImage level=null, background, level2 =null;
    
    Handler handler, handlerBall;
    Camera cam;
    static Texture tex;
    Random rand = new Random();
    
	public synchronized void start()
	{
	  if(running)
	  {
		return;
	  }
	  running =true;
	  thread = new Thread(this);
	  thread.start();
	  
	}
	
	public void init()
	{
      WIDTH = getWidth();
      HEIGHT = getHeight();
   
      tex = new Texture();
      
      BufferedImageLoader loader = new BufferedImageLoader();
     
      
     
    	  level = loader.loadImage("/level.png");//loading the level
    	  background = loader.loadImage("/landscape.png"); 
       
      
       
       cam = new Camera(0,0); 
	   handler = new Handler(cam);
	    handler.LoadImageLevel(level);
	    handler.addObject(new Enemy(100,200, handler,1,1, ObjectId.Enemy));
	  handler.addObject(new Player(100,100,handler, cam, ObjectId.Player));
	  this.addKeyListener(new KeyInput(handler));
	  
	}
	
	
	public void run() 
	{
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		} 
	}
	
	private void tick()
	{
	  handler.tick();
	  for(int i=0; i< handler.object.size(); i++)
		{
		  if(handler.object.get(i).getId() == ObjectId.Player)
		  {
			cam.tick(handler.object.get(i));
		  }
		  
		  if(handler.object.get(i).getId() == ObjectId.Ball)
		  {
			cam.tick(handler.object.get(i));
		  }
		  if(handler.object.get(i).getId() == ObjectId.Enemy)
		  {
			//cam.tick(handler.object.get(i));
		  }
		}
	}
	
	private void render()
	{

	  BufferStrategy bs = this.getBufferStrategy();
	  if(bs == null)
	  {
		this.createBufferStrategy(numBuffer);
		return;
	  }
	  Graphics g = bs.getDrawGraphics();
	  Graphics2D g2d = (Graphics2D) g;

	  //////////////////////////////////////////////////////////////
	  
	  
	  g.setColor(new Color(130,200,234));
	  g.fillRect(0,0, getWidth(),getHeight());

	  g.drawImage(background,0,0,this);
	  g2d.translate(cam.getX(),cam.getY());//begin of the camera
	    for(int xx=0; xx< background.getWidth()* 5; xx += background.getWidth())
	    {
	      g.drawImage(background,xx, 0,this);
	    }
	    handler.render(g);
	  
	  
	  g2d.translate(-cam.getX(), -cam.getY());
	  
	  ///////////////////////////////////////////////////////
	  g.dispose();
	  bs.show();
	}
	
	private void LoadImageLevel(BufferedImage image)
	{
		int w = image.getWidth();
		int h = image.getHeight();
		System.out.println("width, height: "+w+" "+h);
		
		for(int xx=0; xx < h; xx++)
		{
			for(int yy=0; yy< w; yy++)
			{
			  int pixel = image.getRGB(xx, yy);
			  int red = (pixel>>16) & 0xff;
			  int green = (pixel >>8) & 0xff;
			  int blue = (pixel) & 0xff;
			  
			  if(red==255 && green ==255 & blue==255)
			  {
				  handler.addObject(new Block(xx*32, yy*32,0, ObjectId.Block));
			  }
			  if(red==0 && green ==0 & blue==255)
			  {
				  handler.addObject(new Player(xx*32, yy*32, handler,cam,ObjectId.Player));
			  } 
			  
			}
		}
		
	}
	
	public static Texture getInstance()
	{
      return tex;
	}
	
	public static void main(String args[])
	{
		  new Window(800, 600, "BladeRunner Platform Prototype", new Game());
		
	}

}
