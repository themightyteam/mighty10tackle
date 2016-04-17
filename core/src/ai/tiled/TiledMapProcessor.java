package ai.tiled;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludum.mighty.square.world.pathnodes.PathNode;

public class TiledMapProcessor 
{
	
	private TiledMap map;
	
	float tileWidth;
	float tileHeight;
	
	public TiledMapProcessor(TiledMap map)
	{
		this.map = map;
		
		Iterator<String> keyIt =  this.map.getProperties().getKeys();
		
		while(keyIt.hasNext())
		{
			String prop = keyIt.next();
			
			System.out.println("PROP "+prop);
			
		
		}
		

		this.tileWidth = Float.parseFloat(this.map.getProperties().get("tilewidth").toString());
		
		this.tileHeight=  Float.parseFloat(this.map.getProperties().get("tileheight").toString());
		
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param zoneLayer
	 * @return
	 */
	public List<PathNode> obtainZoning(String zoneLayer)
	{
		List<PathNode> zoneList = new ArrayList<PathNode>();
		
		MapObjects zoningObjects = this.map.getLayers().get(zoneLayer).getObjects();
	
		//Process Zoning first
		for (int i = 0; i< zoningObjects.getCount(); i ++)
		{
			MapObject zone = zoningObjects.get(i);
			
			int idZone = Integer.parseInt(zone.getName());
			
			//FIXME Do the transformations here
			float x = Float.parseFloat( zone.getProperties().get("x").toString())/this.tileWidth;
			float y = Float.parseFloat( zone.getProperties().get("y").toString())/this.tileHeight;
			float width = Float.parseFloat( zone.getProperties().get("width").toString())/this.tileWidth;
			float height = Float.parseFloat( zone.getProperties().get("height").toString())/this.tileHeight;
				
			Rectangle zoneRect = new Rectangle();
			zoneRect.setX(x);
			zoneRect.setY(y);
			zoneRect.setWidth(width);
			zoneRect.setHeight(height);
			
			Vector2 refPoint = zoneRect.getCenter(new Vector2());
			
			PathNode pathNode = new PathNode(idZone, refPoint, zoneRect);
		
			zoneList.add(pathNode);
			
		}
		
		return zoneList;
			
	}	/**
	 * 
	 * 
	 * 
	 * @param pathLayer
	 * @return
	 */
	public List<PathNode> obtainPathFinding(String pathLayer)
	{
		List<PathNode> pathList = new ArrayList<PathNode>();
		
		MapObjects pathObjects = this.map.getLayers().get(pathLayer).getObjects();
	
		//Process Zoning first
		for (int i = 0; i< pathObjects.getCount(); i ++)
		{
			MapObject zone = pathObjects.get(i);
			
			int idZone = Integer.parseInt(zone.getName());
			
			
				

			//FIXME Do the transformations here
			float x = Float.parseFloat( zone.getProperties().get("x").toString())/this.tileWidth;
			float y = Float.parseFloat( zone.getProperties().get("y").toString())/this.tileHeight;
			float width = Float.parseFloat( zone.getProperties().get("width").toString())/this.tileWidth;
			float height = Float.parseFloat( zone.getProperties().get("height").toString())/this.tileHeight;
			

			
			if (idZone == 20)
			{
				System.out.println("NODE20XY "+x+" "+ y);
			}
			
			Rectangle zoneRect = new Rectangle();
			zoneRect.setX(x);
			zoneRect.setY(y);
			zoneRect.setWidth(width);
			zoneRect.setHeight(height);
			
			List<Integer> normalList = new ArrayList<Integer>();
			List<Integer> jumpList = new ArrayList<Integer>();
			List<Integer> landingList = new ArrayList<Integer>();
			
			if (!zone.getProperties().get("normalList").toString().equals(""))
			{
				String [] normalListInMap = zone.getProperties().get("normalList").toString().split(",");
				
				for (String normalNodeId : normalListInMap)
				{
					if (!normalNodeId.trim().equals(""))
					normalList.add(Integer.parseInt(normalNodeId.trim()));
				}
			}
			
			if (!zone.getProperties().get("jumpList").toString().equals(""))
			{
				String [] jumpListInMap = zone.getProperties().get("jumpList").toString().split(",");
				
				for (String jumpNodeId : jumpListInMap)
				{
					if (!jumpNodeId.trim().equals(""))
		
					
						jumpList.add(Integer.parseInt(jumpNodeId.trim()));
				}
			}
			
			
			if (!zone.getProperties().get("landingList").toString().equals(""))
			{
				String [] landListInMap = zone.getProperties().get("landingList").toString().split(",");
				
				for (String landNodeId : landListInMap)
				{
					if (!landNodeId.trim().equals(""))
					landingList.add(Integer.parseInt(landNodeId.trim()));
				}
			}
			
			
			Vector2 refPoint = zoneRect.getCenter(new Vector2());
			
			
			
			PathNode pathNode = new PathNode(idZone, refPoint, zoneRect);
		
			//Add extra list to path node
			pathNode.setConnectionList(normalList);
			pathNode.setConnectionJumpList(jumpList);
			pathNode.setConnectionLandingList(landingList);
			
			pathList.add(pathNode);
		
		
		}
		
		return pathList;
			
	}

}
