package perssistence;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import models.Player;
import utils.Util;

public class FileManager {

	Document document;
	private String pathMyInfo;
	private String path;

	public FileManager() {
//		this.path = getClass().getResource(ConstantsMOD.URL_INFO_FILE).getPath();
		this.pathMyInfo = "src" + System.getProperty("file.separator") + "perssistence" + System.getProperty("file.separator")+ "myInfo.xml";
		this.path = "src" + System.getProperty("file.separator") + "perssistence" + System.getProperty("file.separator")+ "game.xml";
	}

	private void readFileXml(byte[] fileBytes) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		document = docBuilder.parse(new ByteArrayInputStream(fileBytes));
		document.getDocumentElement().normalize();
	}
	
	public ArrayList<Player> loadInfoPlayers(byte[] fileBytes) throws ParserConfigurationException, SAXException, IOException{
		readFileXml(fileBytes);
		ArrayList<Player> players = new ArrayList<Player>();
		for (int i = 0; i < 4; i++) {
			players.add(loadPlayer(i));
		}
		return players;
	}
	
	private Player loadPlayer(int i) {
		NodeList nodeList = document.getElementsByTagName("Player" +i);
		Element element = (Element)nodeList.item(0);
		return Util.getPlayer(element);
	}
	
	private Element writePlayer(Document document, Element elementPlayer, Player player) {
		Element idPlayer = document.createElement("idPlayer");
		Text nodeidPlayer = document.createTextNode(String.valueOf(player.getId()));
		idPlayer.appendChild(nodeidPlayer);
		
		Element namePlayer = document.createElement("namePlayer");
		Text nodeNamePlayer = document.createTextNode(player.getName());
		namePlayer.appendChild(nodeNamePlayer);
		
		Element scorePlayer = document.createElement("scorePlayer");
		Text nodeScorePlayer = document.createTextNode(String.valueOf(player.getScore()));
		scorePlayer.appendChild(nodeScorePlayer);
		
		Element idAvatar = document.createElement("idAvatar");
		Text nodeIdAvatar = document.createTextNode(String.valueOf(player.getAvatar()));
		idAvatar.appendChild(nodeIdAvatar);
		
		Element posInitX = document.createElement("posXPlayer");
		Text nodePosX = document.createTextNode(String.valueOf(player.getX()));
		posInitX.appendChild(nodePosX);

		Element posInitY = document.createElement("posYPlayer");
		Text nodePosY = document.createTextNode(String.valueOf(player.getY()));
		posInitY.appendChild(nodePosY);
		
		Element life = document.createElement("lifePlayer");
		Text nodeLife = document.createTextNode(String.valueOf(player.getLife()));
		life.appendChild(nodeLife);
		
		Element fort = document.createElement("fortPlayer");
		Text nodeFort = document.createTextNode(String.valueOf(player.getFort()));
		fort.appendChild(nodeFort);
		
		elementPlayer.appendChild(idPlayer);
		elementPlayer.appendChild(namePlayer);
		elementPlayer.appendChild(scorePlayer);
		elementPlayer.appendChild(idAvatar);
		elementPlayer.appendChild(posInitX);
		elementPlayer.appendChild(posInitY);
		elementPlayer.appendChild(life);
		elementPlayer.appendChild(fort);
		return elementPlayer;
	}
	
	public void writeMyInfo(Player player) throws ParserConfigurationException, TransformerFactoryConfigurationError,
			TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document document = implementation.createDocument(null, "player", null);
		document.setXmlVersion("1.0");
		Source source = new DOMSource(document);

		Element root = document.getDocumentElement();

		Element elementPlayers = document.createElement("Player");
		root.appendChild(writePlayer(document, elementPlayers, player));

		StreamResult result = new StreamResult(new File(this.pathMyInfo + player.getId()));
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(source, result);
	}
	
}