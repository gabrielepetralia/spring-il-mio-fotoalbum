package org.java.app;

import org.java.app.db.serv.PhotoService;
import org.java.app.db.pojo.Category;
import org.java.app.db.pojo.Message;
import org.java.app.db.pojo.Photo;
import org.java.app.db.serv.CategoryService;
import org.java.app.db.serv.MessageService;
import org.java.app.mvc.auth.pojo.Role;
import org.java.app.mvc.auth.pojo.User;
import org.java.app.mvc.auth.serv.RoleService;
import org.java.app.mvc.auth.serv.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {

	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception { 
		
		Category cat1 = new Category("Bianco e nero");
		Category cat2 = new Category("Paesaggi");
		Category cat3 = new Category("Mare");
		Category cat4 = new Category("Montagna");
		Category cat5 = new Category("Ritratti");
		Category cat6 = new Category("Animali");
		Category cat7 = new Category("Architettura");
		Category cat8 = new Category("Cibo");
		
		categoryService.save(cat1);		
		categoryService.save(cat2);
		categoryService.save(cat3);	
		categoryService.save(cat4);	
		categoryService.save(cat5);	
		categoryService.save(cat6);
		categoryService.save(cat7);	
		categoryService.save(cat8);
		
		
		Photo ph1 = new Photo(
				"Delizie in Bianco e Nero",
				"Un assortimento di deliziosi dolcetti, catturati in uno sfondo in bianco e nero che enfatizza la texture e la tentazione. Ogni morso è un'esplosione di sapore, mentre la fotografia trasmette il desiderio di indulgere.",
				"https://c.wallhere.com/photos/a8/3e/blackandwhite_bw_food_film_35mm_dessert_cupcakes_etc-716643.jpg!d",
				true,
				cat1, cat8
			);
		
		Photo ph2 = new Photo(
				"Montagne Celesti",
				"Nel cuore delle maestose montagne, sotto un cielo stellato punteggiato di migliaia di luci lontane. Un'atmosfera magica in cui la natura e l'universo si fondono in una sinfonia di bellezza e mistero.",
				"https://c.wallhere.com/photos/8a/98/nature_Nature_photography_anime_boys_anime_couple_mountain_top_mountain_view_landscape_Desktopography-2282974.jpg!d",
				true,
				cat2, cat4
			);
		
		Photo ph3 = new Photo(
				"Il Re in Bianco e Nero",
				"La potenza e la maestosità di un leone, catturate in un'immagine in bianco e nero che enfatizza la sua forza e il suo regale dominio sulla savana africana.",
				"https://c.wallhere.com/photos/b7/b8/monochrome_lion-2076111.jpg!d",
				true,
				cat1, cat6
			);
		
		Photo ph4 = new Photo(
				"Momento di Dolcezza",
				"Una tazzina di caffè fumante, circondata da biscotti appena sfornati. Il profumo accogliente del caffè si sposa con il croccante dei biscotti, creando un'atmosfera di conforto e piacere.",
				"https://c.wallhere.com/photos/23/01/cookies_coffee_breakfast-576416.jpg!d",
				true,
				cat8
			);
		
		Photo ph5 = new Photo(
				"Luci della Metropoli",
				"Una vista notturna mozzafiato della città, con grattacieli imponenti che si ergono verso il cielo stellato. Le luci delle case e degli edifici si accendono come stelle in una notte urbana, creando un'atmosfera di energia e vitalità.",
				"https://c.wallhere.com/photos/fe/35/Shanghai_China_city_night_lights_skyscraper_architecture_landscape-2189103.jpg!d",
				true,
				cat7
			);
		
		Photo ph6 = new Photo(
				"Tranquillità Grigia",
				"Un paesaggio marino in bianco e nero, in cui le nuvole grigie si riflettono sull'acqua calma del mare. Un'atmosfera di serenità e mistero avvolge questa immagine, trasportando l'osservatore in un momento di quiete e contemplazione.",
				"https://c.wallhere.com/photos/6b/17/photography_monochrome_landscape_nature_water_stones_coast_Rangitoto-77637.jpg!d",
				true,
				cat1, cat2, cat3
			);
		
		Photo ph7 = new Photo(
				"Golden Horizon",
				"Un incantevole tramonto sul mare, dove il cielo si trasforma in sfumature di oro e rosso mentre il sole scompare all'orizzonte, regalando un momento di serenità e bellezza senza tempo.",
				"https://c.wallhere.com/photos/bb/68/1200x800_px_landscape-1074589.jpg!d",
				true,
				cat2, cat3
			);
		
		Photo ph8 = new Photo(
				"Eleganza senza Tempo",
				"Un ritratto in bianco e nero di una giovane Monica Bellucci, dove la sua bellezza sensuale è catturata in tutta la sua magnificenza. L'espressione misteriosa racconta una storia di fascino e allure senza tempo.",
				"https://c.wallhere.com/photos/c2/82/monica_bellucci_actress_face_brunette_bw-550868.jpg!d",
				true,
				cat1, cat5
			);
		
		Photo ph9 = new Photo(
				"Il Lupo Guardian delle Cime",
				"Un maestoso lupo si erge sulle vette innevate delle montagne. Con un senso di profonda connessione con la natura, il lupo osserva silenziosamente l'incantevole paesaggio di neve.",
				"https://c.wallhere.com/photos/57/cf/mountains_wolf_landscape_clouds_snow_mist-58357.jpg!d",
				true,
				cat2, cat4, cat6
			);
		
		Photo ph10 = new Photo(
				"Riflessi Urbani",
				"L'imponente sede di Apple, circondata da grattacieli e architettura moderna, è catturata in un suggestivo bianco e nero. La fusione di vetrate e superfici specchianti crea un gioco di riflessi che si intrecciano con l'essenza dell'innovazione.",
				"https://c.wallhere.com/photos/d8/ba/app_storm_apple_mac_character_building_office-776266.jpg!d",
				true,
				cat1, cat7
			);
		
		Photo ph11 = new Photo(
				"Giovinezza Radiante",
				"Un ritratto avvincente di Angelina Jolie da giovane, in cui la sua bellezza e il suo carisma emergono in modo straordinario. Il suo sguardo magnetico cattura l'attenzione, rivelando la promessa di una futura icona di Hollywood.",
				"https://c.wallhere.com/images/b7/6e/0348e2918b0c93fdf5ddfc0b9588-1488669.jpg!d",
				true,
				cat5
			);
		
		Photo ph12 = new Photo(
				"Sotto il Regno dei Coralli",
				"Un'immersione nella vita sottomarina, in cui pesci rossi nuotano tra i vibranti coralli. Il mondo sottomarino si apre davanti agli occhi dell'osservatore, rivelando la bellezza e la diversità della vita marina.",
				"https://c.wallhere.com/photos/59/a2/1920x1200_px_Coral_egypt_fishes_ocean_sea_tropical_underwater-1651151.jpg!d",
				true,
				cat3, cat6
			);
		
		photoService.save(ph1);
		photoService.save(ph2);
		photoService.save(ph3);
		photoService.save(ph4);
		photoService.save(ph5);
		photoService.save(ph6);
		photoService.save(ph7);
		photoService.save(ph8);
		photoService.save(ph9);
		photoService.save(ph10);
		photoService.save(ph11);
		photoService.save(ph12);
		
		
		Message msg1 = new Message("mariorossi@gmail.com", "Buongiorno, mi chiamo Mario. Sono interessato alla tua fotografia e vorrei discutere una possibile collaborazione. Attendo risposta, grazie.");
		Message msg2 = new Message("giuseppeverdi@live.it", "Ciao, volevo farti i complimenti per le tue straordinarie fotografie. Hai davvero un talento unico nel catturare momenti speciali. Continua così!");
		Message msg3 = new Message("giuseppebianchi@gmail.com", "Salve, sto cercando un fotografo per il mio matrimonio che si terrà il 28/12/2023. Ho visto il tuo portfolio e sono rimasto colpito dal tuo lavoro. Saresti disponibile? Grazie in anticipo.");
		
		messageService.save(msg1);
		messageService.save(msg2);
		messageService.save(msg3);
	
		
		Role admin = new Role("admin");
		Role user = new Role("user");
		
		roleService.save(admin);
		roleService.save(user);
		
		final String pwdAdmin = new BCryptPasswordEncoder().encode("pwd");
		final String pwdUser = new BCryptPasswordEncoder().encode("pwd");
		
		User guybrushAdmin = new User("admin", pwdAdmin, admin, user);
		User guybrushUser = new User("user", pwdUser, user);
		
		userService.save(guybrushAdmin);
		userService.save(guybrushUser);
		
		System.out.println("Insert OK!");
		
	}

}
