package com.mx262cal726.Dodge.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.mx262cal726.Dodge.window.Game;
import com.mx262cal726.Dodge.framework.GameObject;
import com.mx262cal726.Dodge.framework.ObjectId;
import com.mx262cal726.Dodge.framework.Texture;

public class Bullet extends GameObject
{
    Texture tex = Game.getInstance();
    
	public Bullet(float x, float y, ObjectId id, int velX)
	{
		super(x, y, id);
		this.velX =velX;
	}

	public void tick(LinkedList<GameObject> object) 
	{
	  x+= velX;
	}

	public void render(Graphics g)
	{

      g.drawImage(tex.jump[1], (int)x, (int)y, null);
	}

	public Rectangle getBounds() 
	{
		return new Rectangle((int)x, (int)y, 16,16);
	}

}
