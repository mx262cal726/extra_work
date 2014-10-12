package com.mx262cal726.Dodge.framework;

import java.awt.image.BufferedImage;

import com.mx262cal726.Dodge.window.BufferedImageLoader;

public class Texture 
{
  SpriteSheet bs, ps, js,ls,ss,qs;
  private BufferedImage block_sheet =null;
  private BufferedImage player_sheet =null;
  private BufferedImage Jump_sheet =null;
  private BufferedImage silver_sheet=null;
  private BufferedImage lose_sheet=null;
  
  public BufferedImage[] block = new BufferedImage[2];
  public BufferedImage[] player = new BufferedImage[8];
  public BufferedImage[] jump = new BufferedImage[3];
  public BufferedImage[] silver = new BufferedImage[17];
  public BufferedImage[] lose = new BufferedImage[3];
  
  public Texture()
  {
	BufferedImageLoader loader = new BufferedImageLoader();
	try{
		block_sheet = loader.loadImage("/block.png");
		player_sheet = loader.loadImage("/Player.png");
		Jump_sheet = loader.loadImage("/santaJump.png");
		silver_sheet = loader.loadImage("/silver.png");
		lose_sheet = loader.loadImage("/santaLose.png");
		
		
	}catch(Exception e){
		e.printStackTrace();
		
	}
	bs = new SpriteSheet(block_sheet);
	ps = new SpriteSheet(player_sheet);
	js = new SpriteSheet(Jump_sheet);
	ss = new SpriteSheet(silver_sheet);
	qs = new SpriteSheet(lose_sheet);
	getTextures();
  }
  
  private void getTextures()
  {
	block[0] = bs.grabImage(1,1,30,30);//dirt block
	block[1] = bs.grabImage(2,1,30,30);//grass block
	
	player[0]= ps.grabImage(1,1,30,60);//santa player
	player[1]= ps.grabImage(2,1,30,60);//santa player
	player[2]= ps.grabImage(3,1,30,60);//santa player
	player[3]= ps.grabImage(4,1,30,60);//santa player
	
	//Player runs backward
	player[4]= ps.grabImage(1,2,30,60);//santa player
	player[5]= ps.grabImage(2,2,30,60);//santa player
	player[6]= ps.grabImage(3,2,30,60);//santa player
	player[7]= ps.grabImage(4,2,30,60);//santa player
	
	jump[0] = js.grabImage(1, 1, 30, 60);
	jump[1] = js.grabImage(2,1,30,30);
	jump[2] = js.grabImage(3, 1, 30, 30);
	
	silver[0] = ss.grabImage(1, 1, 40, 73);
	silver[1] = ss.grabImage(2, 1, 40, 73);
	silver[2] = ss.grabImage(3, 1, 40, 73);
	silver[3] = ss.grabImage(4, 1, 40, 73);
	silver[4] = ss.grabImage(5, 1, 40, 73);
	silver[5] = ss.grabImage(6, 1, 40, 73);
	silver[6] = ss.grabImage(7, 1, 40, 73);
	silver[7] = ss.grabImage(8, 1, 40, 73);
	silver[8] = ss.grabImage(1, 2, 35, 73);
	silver[9] = ss.grabImage(2, 2, 35, 73);
	silver[10] = ss.grabImage(3, 2, 35, 73);
	silver[11] = ss.grabImage(4, 2, 35, 73);
	silver[12] = ss.grabImage(5, 2, 35, 73);
	silver[13] = ss.grabImage(6, 2, 35, 73);
	silver[14] = ss.grabImage(7, 2, 35, 73);
	silver[15] = ss.grabImage(8, 2, 35, 73);
	silver[16] = ss.grabImage(1, 5, 200, 100);
	
	lose[0] = qs.grabImage(1,1,30,120);//santa hit by ball
	lose[1] = qs.grabImage(2,1,35,120);//santa hit by ball
	lose[2] = qs.grabImage(3,1,38,120);//santa hit by ball

  }
}
