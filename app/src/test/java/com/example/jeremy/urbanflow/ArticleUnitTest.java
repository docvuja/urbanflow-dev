package com.example.jeremy.urbanflow;

import com.example.jeremy.urbanflow.Beans.Article;

import org.junit.*;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Ashley on 06/01/2017.
 */

public class ArticleUnitTest {
    public static final String EXPECTED_TITLE = "Retour sur la conférence-débat de @NoiseLaVille";
    public static final String EXPECTED_IMAGE = "image1.jpg";
    public static final String EXPECTED_DESCRIPTION = "Ce soir, j’ai pu retourner sur les bancs de l’école (que j’ai quitté récemment, je vous rassure) en venant assister à une conférence-débat au sein de Sciences Po." +
            "\n" + "Organisé par l’association étudiante Noise La Ville, elle avait pour thème : “Danses Hip-Hop & l’Etat, quelles perspectives ?” et conviait en ce début de soirée différents acteurs évoluant au sein et/ou à proximité de la culture danse Hip-Hop.";
    public static final Date EXPECTED_DATE = new GregorianCalendar(2016, 2, 12).getTime();
    public static final String EXPECTED_AUTHOR = "KIUDEE DAVIE";
    public static final String EXPECTED_TEXT = "Accompagné des autres membres du Moovement ainsi qu’Axel & Mélissa, c’est dans le bel amphithéâtre Émile Boutmy et sur une introduction de Pierre (co-fondateur de l’association organisatrice) que cela a débuté.\n" +
            "\n" +
            "Sur l’estrade, on retrouve Aurélien Djakouane (sociologue), Laurent Vinauger (tout nouveau Délégué à la Danse à la Direction Générale de la Création artistique au Ministère de la Culture et la Communication), Nasty (danseur, fondateur de Quality Street), Michel” Meech” Onomo (danseur et chorégraphe), Chloé Le Nôtre (chef de projet adjointe à la Villette, conseillère artistique et technique du projet IADU) et Bruce “Ykanji” Soné (danseur & fondateur du Juste Debout) et le journaliste Yérim Sar en tant que médiateur.\n" +
            "\n" +
            "Anne Nguyen manque à l’appel mais c’est dans une vidéo tourné au préalable qu’elle exprime de manière assez évasé son attachement à vouloir que l’on respecte les codes de la danse Hip-Hop en prenant exemple de son parcours et son mentor (Laos). Elle a tenu à signifier que son travail auprès de ces jeunes, à qui elle enseigne à Sciences Po, se fait dans la direction que chacun puisse avoir les outils pour se développer personnellement en précisant que “on reconnaît un bon prof, lorsque ses élèves ne dansent pas comme lui“. Bien que je la rejoins sur certains points, je regrette son absence car j’aurais voulu la voir affirmer ses propos devant les autres interlocuteurs et enfin avoir une réelle confrontation des différents dires qui circulent.\n" +
            "\n" +
            "La question du DNSP est vite abordé avec Laurent Vinaugier qui nous explique être arrivé il y a une semaine au poste de Délégué de la Danse et que l’un des dossiers “posé sur son bureau” était le DNSP. Conscient de l’ampleur du débat qui concerne la commande qui lui a été faite d’étudier la création d’un diplôme pour les interprètes, il était présent ce soir afin d’être à l’écoute de ceux qui sont au coeur dette proposition. A travers ce débat, il amorce un pas vers la discussion qu’il souhaite privilégier. Toute fois, il a abordé des points qui se sont avérés plus houleux qu’il ne semblait l’avoir prévu : comme la récente attribution du titre de “Compagnies Nationale” qui crédibilise certaines compagnies (et donc, pas d’autres) ; le budget annuel de 550 000€ déversés pour 23 compagnies Hip-Hop 23 dont 4 conventionnées, 8 en structuration, 11 en cours de projets (à se demander ce qui choque le plus : le nombre de compagnies ou le budget accordé) ; la multiple réitération de ne “répondre (qu’)à une commande” sans jamais nous préciser le quémandeur, mais aussi la suggestion de “faire en sorte que nos acteurs investissent le gouvernement pour le changer & y contribuer de l’intérieur“.\n" +
            "\n" +
            "Des points qui ont été contre-carré avec merveille par Nasty & Bruce Ykanji. Ce dernier a superbement exprimé son ras-le-bol ainsi que son manque de confiance en un système redondant qui n’a jusque là jamais su apporter les aides suffisantes ainsi que les réponses nécessaires depuis 30 ans. Bien que la question ait été posé, aucune réponse n’a été apporté quant à savoir qui donc a initié cette commande. Entre-nous, disons-le, nous savons que des noms tels que ceux Kader Attou & Mourad Merzouki n’ont pas été évoqués (ce dernier a été convié mais fut absent) bien que nous savons qu’ils soutiennent fortement le “Pour”. J’aurais réellement passé une soirée mémorable si Mme.Nguyen et Mr.Merzouki étaient présents afin que l’on puisse vraiment assister à un débat qui pour le coup s’est pas mal penché sur Mr.Vinauger qui tant bien que mal à voulu affirmer sa démarche et défendre son statut.";
    private Article articleFull;
    private Article articleEmpty;

    @Before
    public void setUp() throws Exception {
        articleFull = new Article("Retour sur la conférence-débat de @NoiseLaVille", "image1.jpg","Ce soir, j’ai pu retourner sur les bancs de l’école (que j’ai quitté récemment, je vous rassure) en venant assister à une conférence-débat au sein de Sciences Po." +
                "\n" + "Organisé par l’association étudiante Noise La Ville, elle avait pour thème : “Danses Hip-Hop & l’Etat, quelles perspectives ?” et conviait en ce début de soirée différents acteurs évoluant au sein et/ou à proximité de la culture danse Hip-Hop.",
        new GregorianCalendar(2016, 2, 12).getTime(), "KIUDEE DAVIE",
                "Accompagné des autres membres du Moovement ainsi qu’Axel & Mélissa, c’est dans le bel amphithéâtre Émile Boutmy et sur une introduction de Pierre (co-fondateur de l’association organisatrice) que cela a débuté.\n" +
                        "\n" +
                        "Sur l’estrade, on retrouve Aurélien Djakouane (sociologue), Laurent Vinauger (tout nouveau Délégué à la Danse à la Direction Générale de la Création artistique au Ministère de la Culture et la Communication), Nasty (danseur, fondateur de Quality Street), Michel” Meech” Onomo (danseur et chorégraphe), Chloé Le Nôtre (chef de projet adjointe à la Villette, conseillère artistique et technique du projet IADU) et Bruce “Ykanji” Soné (danseur & fondateur du Juste Debout) et le journaliste Yérim Sar en tant que médiateur.\n" +
                        "\n" +
                        "Anne Nguyen manque à l’appel mais c’est dans une vidéo tourné au préalable qu’elle exprime de manière assez évasé son attachement à vouloir que l’on respecte les codes de la danse Hip-Hop en prenant exemple de son parcours et son mentor (Laos). Elle a tenu à signifier que son travail auprès de ces jeunes, à qui elle enseigne à Sciences Po, se fait dans la direction que chacun puisse avoir les outils pour se développer personnellement en précisant que “on reconnaît un bon prof, lorsque ses élèves ne dansent pas comme lui“. Bien que je la rejoins sur certains points, je regrette son absence car j’aurais voulu la voir affirmer ses propos devant les autres interlocuteurs et enfin avoir une réelle confrontation des différents dires qui circulent.\n" +
                        "\n" +
                        "La question du DNSP est vite abordé avec Laurent Vinaugier qui nous explique être arrivé il y a une semaine au poste de Délégué de la Danse et que l’un des dossiers “posé sur son bureau” était le DNSP. Conscient de l’ampleur du débat qui concerne la commande qui lui a été faite d’étudier la création d’un diplôme pour les interprètes, il était présent ce soir afin d’être à l’écoute de ceux qui sont au coeur dette proposition. A travers ce débat, il amorce un pas vers la discussion qu’il souhaite privilégier. Toute fois, il a abordé des points qui se sont avérés plus houleux qu’il ne semblait l’avoir prévu : comme la récente attribution du titre de “Compagnies Nationale” qui crédibilise certaines compagnies (et donc, pas d’autres) ; le budget annuel de 550 000€ déversés pour 23 compagnies Hip-Hop 23 dont 4 conventionnées, 8 en structuration, 11 en cours de projets (à se demander ce qui choque le plus : le nombre de compagnies ou le budget accordé) ; la multiple réitération de ne “répondre (qu’)à une commande” sans jamais nous préciser le quémandeur, mais aussi la suggestion de “faire en sorte que nos acteurs investissent le gouvernement pour le changer & y contribuer de l’intérieur“.\n" +
                        "\n" +
                        "Des points qui ont été contre-carré avec merveille par Nasty & Bruce Ykanji. Ce dernier a superbement exprimé son ras-le-bol ainsi que son manque de confiance en un système redondant qui n’a jusque là jamais su apporter les aides suffisantes ainsi que les réponses nécessaires depuis 30 ans. Bien que la question ait été posé, aucune réponse n’a été apporté quant à savoir qui donc a initié cette commande. Entre-nous, disons-le, nous savons que des noms tels que ceux Kader Attou & Mourad Merzouki n’ont pas été évoqués (ce dernier a été convié mais fut absent) bien que nous savons qu’ils soutiennent fortement le “Pour”. J’aurais réellement passé une soirée mémorable si Mme.Nguyen et Mr.Merzouki étaient présents afin que l’on puisse vraiment assister à un débat qui pour le coup s’est pas mal penché sur Mr.Vinauger qui tant bien que mal à voulu affirmer sa démarche et défendre son statut.");

        articleEmpty = new Article(null, null, null, null, null, null);
    }

    @Test
    public void testArticleFullDetails() throws Exception {
        Assert.assertNotNull(articleFull);
        Assert.assertEquals(EXPECTED_TITLE  , articleFull.getTitle());
        Assert.assertEquals(EXPECTED_IMAGE, articleFull.getImage());
        Assert.assertEquals(EXPECTED_DESCRIPTION, articleFull.getDescription());
        Assert.assertEquals(EXPECTED_DATE, articleFull.getDate());
        Assert.assertEquals(EXPECTED_AUTHOR, articleFull.getAuthor());
        Assert.assertEquals(EXPECTED_TEXT, articleFull.getText());
    }

    @Test
    public void testArticleEmptyDetails() throws Exception {
        Assert.assertNotNull(articleEmpty);
        Assert.assertNull(articleEmpty.getTitle());
        Assert.assertNull(articleEmpty.getImage());
        Assert.assertNull(articleEmpty.getDescription());
        Assert.assertNull(articleEmpty.getDate());
        Assert.assertNull(articleEmpty.getAuthor());
        Assert.assertNull(articleEmpty.getText());
    }
}