package cuestionario.entidades;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;

import com.orm.SugarContext;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cuestionario.sedesol.com.democuestionario.R;

import static android.content.ContentValues.TAG;

/**
 * Created by asuarezr on 07/04/2017.
 */

public class InicializadorDatos extends Activity {

    public InicializadorDatos(){

    }

    public int InitMunicipio(){
        try {

            List<Municipio> listaMunicipios=new ArrayList();

            listaMunicipios.add(new Municipio("002","Acateno",21));
            listaMunicipios.add(new Municipio("001","Acajete",21));
            listaMunicipios.add(new Municipio("003","Acatlán",21));
            listaMunicipios.add(new Municipio("004","Acatzingo",21));
            listaMunicipios.add(new Municipio("005","Acteopan",21));
            listaMunicipios.add(new Municipio("006","Ahuacatlán",21));
            listaMunicipios.add(new Municipio("007","Ahuatlán",21));
            listaMunicipios.add(new Municipio("008","Ahuazotepec",21));
            listaMunicipios.add(new Municipio("009","Ahuehuetitla",21));
            listaMunicipios.add(new Municipio("010","Ajalpan",21));
            listaMunicipios.add(new Municipio("011","Albino Zertuche",21));
            listaMunicipios.add(new Municipio("012","Aljojuca",21));
            listaMunicipios.add(new Municipio("013","Altepexi",21));
            listaMunicipios.add(new Municipio("014","Amixtlán",21));
            listaMunicipios.add(new Municipio("015","Amozoc",21));
            listaMunicipios.add(new Municipio("016","Aquixtla",21));
            listaMunicipios.add(new Municipio("017","Atempan",21));
            listaMunicipios.add(new Municipio("018","Atexcal",21));
            listaMunicipios.add(new Municipio("019","Atlixco",21));
            listaMunicipios.add(new Municipio("020","Atoyatempan",21));
            listaMunicipios.add(new Municipio("021","Atzala",21));
            listaMunicipios.add(new Municipio("022","Atzitzihuacán",21));
            listaMunicipios.add(new Municipio("023","Atzitzintla",21));
            listaMunicipios.add(new Municipio("024","Axutla",21));
            listaMunicipios.add(new Municipio("025","Ayotoxco de Guerrero",21));
            listaMunicipios.add(new Municipio("026","Calpan",21));
            listaMunicipios.add(new Municipio("027","Caltepec",21));
            listaMunicipios.add(new Municipio("028","Camocuautla",21));
            listaMunicipios.add(new Municipio("029","Caxhuacan",21));
            listaMunicipios.add(new Municipio("030","Coatepec",21));
            listaMunicipios.add(new Municipio("031","Coatzingo",21));
            listaMunicipios.add(new Municipio("032","Cohetzala",21));
            listaMunicipios.add(new Municipio("033","Cohuecan",21));
            listaMunicipios.add(new Municipio("034","Coronango",21));
            listaMunicipios.add(new Municipio("035","Coxcatlán",21));
            listaMunicipios.add(new Municipio("036","Coyomeapan",21));
            listaMunicipios.add(new Municipio("037","Coyotepec",21));
            listaMunicipios.add(new Municipio("038","Cuapiaxtla de Madero",21));
            listaMunicipios.add(new Municipio("039","Cuautempan",21));
            listaMunicipios.add(new Municipio("040","Cuautinchán",21));
            listaMunicipios.add(new Municipio("041","Cuautlancingo",21));
            listaMunicipios.add(new Municipio("042","Cuayuca de Andrade",21));
            listaMunicipios.add(new Municipio("043","Cuetzalan del Progreso",21));
            listaMunicipios.add(new Municipio("044","Cuyoaco",21));
            listaMunicipios.add(new Municipio("045","Chalchicomula de Sesma",21));
            listaMunicipios.add(new Municipio("046","Chapulco",21));
            listaMunicipios.add(new Municipio("047","Chiautla",21));
            listaMunicipios.add(new Municipio("048","Chiautzingo",21));
            listaMunicipios.add(new Municipio("049","Chiconcuautla",21));
            listaMunicipios.add(new Municipio("050","Chichiquila",21));
            listaMunicipios.add(new Municipio("051","Chietla",21));
            listaMunicipios.add(new Municipio("052","Chigmecatitlán",21));
            listaMunicipios.add(new Municipio("053","Chignahuapan",21));
            listaMunicipios.add(new Municipio("054","Chignautla",21));
            listaMunicipios.add(new Municipio("055","Chila",21));
            listaMunicipios.add(new Municipio("056","Chila de la Sal",21));
            listaMunicipios.add(new Municipio("057","Honey",21));
            listaMunicipios.add(new Municipio("058","Chilchotla",21));
            listaMunicipios.add(new Municipio("059","Chinantla",21));
            listaMunicipios.add(new Municipio("060","Domingo Arenas",21));
            listaMunicipios.add(new Municipio("061","Eloxochitlán",21));
            listaMunicipios.add(new Municipio("062","Epatlán",21));
            listaMunicipios.add(new Municipio("063","Esperanza",21));
            listaMunicipios.add(new Municipio("064","Francisco Z. Mena",21));
            listaMunicipios.add(new Municipio("065","General Felipe Ángeles",21));
            listaMunicipios.add(new Municipio("066","Guadalupe",21));
            listaMunicipios.add(new Municipio("067","Guadalupe Victoria",21));
            listaMunicipios.add(new Municipio("068","Hermenegildo Galeana",21));
            listaMunicipios.add(new Municipio("069","Huaquechula",21));
            listaMunicipios.add(new Municipio("070","Huatlatlauca",21));
            listaMunicipios.add(new Municipio("071","Huauchinango",21));
            listaMunicipios.add(new Municipio("072","Huehuetla",21));
            listaMunicipios.add(new Municipio("073","Huehuetlán el Chico",21));
            listaMunicipios.add(new Municipio("074","Huejotzingo",21));
            listaMunicipios.add(new Municipio("075","Hueyapan",21));
            listaMunicipios.add(new Municipio("076","Hueytamalco",21));
            listaMunicipios.add(new Municipio("077","Hueytlalpan",21));
            listaMunicipios.add(new Municipio("078","Huitzilan de Serdán",21));
            listaMunicipios.add(new Municipio("079","Huitziltepec",21));
            listaMunicipios.add(new Municipio("080","Atlequizayan",21));
            listaMunicipios.add(new Municipio("081","Ixcamilpa de Guerrero",21));
            listaMunicipios.add(new Municipio("082","Ixcaquixtla",21));
            listaMunicipios.add(new Municipio("083","Ixtacamaxtitlán",21));
            listaMunicipios.add(new Municipio("084","Ixtepec",21));
            listaMunicipios.add(new Municipio("085","Izúcar de Matamoros",21));
            listaMunicipios.add(new Municipio("086","Jalpan",21));
            listaMunicipios.add(new Municipio("087","Jolalpan",21));
            listaMunicipios.add(new Municipio("088","Jonotla",21));
            listaMunicipios.add(new Municipio("089","Jopala",21));
            listaMunicipios.add(new Municipio("090","Juan C. Bonilla",21));
            listaMunicipios.add(new Municipio("091","Juan Galindo",21));
            listaMunicipios.add(new Municipio("092","Juan N. Méndez",21));
            listaMunicipios.add(new Municipio("093","Lafragua",21));
            listaMunicipios.add(new Municipio("094","Libres",21));
            listaMunicipios.add(new Municipio("095","La Magdalena Tlatlauquitepec",21));
            listaMunicipios.add(new Municipio("096","Mazapiltepec de Juárez",21));
            listaMunicipios.add(new Municipio("097","Mixtla",21));
            listaMunicipios.add(new Municipio("098","Molcaxac",21));
            listaMunicipios.add(new Municipio("099","Cañada Morelos",21));
            listaMunicipios.add(new Municipio("100","Naupan",21));
            listaMunicipios.add(new Municipio("101","Nauzontla",21));
            listaMunicipios.add(new Municipio("102","Nealtican",21));
            listaMunicipios.add(new Municipio("103","Nicolás Bravo",21));
            listaMunicipios.add(new Municipio("104","Nopalucan",21));
            listaMunicipios.add(new Municipio("105","Ocotepec",21));
            listaMunicipios.add(new Municipio("106","Ocoyucan",21));
            listaMunicipios.add(new Municipio("107","Olintla",21));
            listaMunicipios.add(new Municipio("108","Oriental",21));
            listaMunicipios.add(new Municipio("109","Pahuatlán",21));
            listaMunicipios.add(new Municipio("110","Palmar de Bravo",21));
            listaMunicipios.add(new Municipio("111","Pantepec",21));
            listaMunicipios.add(new Municipio("112","Petlalcingo",21));
            listaMunicipios.add(new Municipio("113","Piaxtla",21));
            listaMunicipios.add(new Municipio("114","Puebla",21));
            listaMunicipios.add(new Municipio("115","Quecholac",21));
            listaMunicipios.add(new Municipio("116","Quimixtlán",21));
            listaMunicipios.add(new Municipio("117","Rafael Lara Grajales",21));
            listaMunicipios.add(new Municipio("118","Los Reyes de Juárez",21));
            listaMunicipios.add(new Municipio("119","San Andrés Cholula",21));
            listaMunicipios.add(new Municipio("120","San Antonio Cañada",21));
            listaMunicipios.add(new Municipio("121","San Diego la Mesa Tochimiltzingo",21));
            listaMunicipios.add(new Municipio("122","San Felipe Teotlalcingo",21));
            listaMunicipios.add(new Municipio("123","San Felipe Tepatlán",21));
            listaMunicipios.add(new Municipio("124","San Gabriel Chilac",21));
            listaMunicipios.add(new Municipio("125","San Gregorio Atzompa",21));
            listaMunicipios.add(new Municipio("126","San Jerónimo Tecuanipan",21));
            listaMunicipios.add(new Municipio("127","San Jerónimo Xayacatlán",21));
            listaMunicipios.add(new Municipio("128","San José Chiapa",21));
            listaMunicipios.add(new Municipio("129","San José Miahuatlán",21));
            listaMunicipios.add(new Municipio("130","San Juan Atenco",21));
            listaMunicipios.add(new Municipio("131","San Juan Atzompa",21));
            listaMunicipios.add(new Municipio("132","San Martín Texmelucan",21));
            listaMunicipios.add(new Municipio("133","San Martín Totoltepec",21));
            listaMunicipios.add(new Municipio("134","San Matías Tlalancaleca",21));
            listaMunicipios.add(new Municipio("135","San Miguel Ixitlán",21));
            listaMunicipios.add(new Municipio("136","San Miguel Xoxtla",21));
            listaMunicipios.add(new Municipio("137","San Nicolás Buenos Aires",21));
            listaMunicipios.add(new Municipio("138","San Nicolás de los Ranchos",21));
            listaMunicipios.add(new Municipio("139","San Pablo Anicano",21));
            listaMunicipios.add(new Municipio("140","San Pedro Cholula",21));
            listaMunicipios.add(new Municipio("141","San Pedro Yeloixtlahuaca",21));
            listaMunicipios.add(new Municipio("142","San Salvador el Seco",21));
            listaMunicipios.add(new Municipio("143","San Salvador el Verde",21));
            listaMunicipios.add(new Municipio("144","San Salvador Huixcolotla",21));
            listaMunicipios.add(new Municipio("145","San Sebastián Tlacotepec",21));
            listaMunicipios.add(new Municipio("146","Santa Catarina Tlaltempan",21));
            listaMunicipios.add(new Municipio("147","Santa Inés Ahuatempan",21));
            listaMunicipios.add(new Municipio("148","Santa Isabel Cholula",21));
            listaMunicipios.add(new Municipio("149","Santiago Miahuatlán",21));
            listaMunicipios.add(new Municipio("150","Huehuetlán el Grande",21));
            listaMunicipios.add(new Municipio("151","Santo Tomás Hueyotlipan",21));
            listaMunicipios.add(new Municipio("152","Soltepec",21));
            listaMunicipios.add(new Municipio("153","Tecali de Herrera",21));
            listaMunicipios.add(new Municipio("154","Tecamachalco",21));
            listaMunicipios.add(new Municipio("155","Tecomatlán",21));
            listaMunicipios.add(new Municipio("156","Tehuacán",21));
            listaMunicipios.add(new Municipio("157","Tehuitzingo",21));
            listaMunicipios.add(new Municipio("158","Tenampulco",21));
            listaMunicipios.add(new Municipio("159","Teopantlán",21));
            listaMunicipios.add(new Municipio("160","Teotlalco",21));
            listaMunicipios.add(new Municipio("161","Tepanco de López",21));
            listaMunicipios.add(new Municipio("162","Tepango de Rodríguez",21));
            listaMunicipios.add(new Municipio("163","Tepatlaxco de Hidalgo",21));
            listaMunicipios.add(new Municipio("164","Tepeaca",21));
            listaMunicipios.add(new Municipio("165","Tepemaxalco",21));
            listaMunicipios.add(new Municipio("166","Tepeojuma",21));
            listaMunicipios.add(new Municipio("167","Tepetzintla",21));
            listaMunicipios.add(new Municipio("168","Tepexco",21));
            listaMunicipios.add(new Municipio("169","Tepexi de Rodríguez",21));
            listaMunicipios.add(new Municipio("170","Tepeyahualco",21));
            listaMunicipios.add(new Municipio("171","Tepeyahualco de Cuauhtémoc",21));
            listaMunicipios.add(new Municipio("172","Tetela de Ocampo",21));
            listaMunicipios.add(new Municipio("173","Teteles de Avila Castillo",21));
            listaMunicipios.add(new Municipio("174","Teziutlán",21));
            listaMunicipios.add(new Municipio("175","Tianguismanalco",21));
            listaMunicipios.add(new Municipio("176","Tilapa",21));
            listaMunicipios.add(new Municipio("177","Tlacotepec de Benito Juárez",21));
            listaMunicipios.add(new Municipio("178","Tlacuilotepec",21));
            listaMunicipios.add(new Municipio("179","Tlachichuca",21));
            listaMunicipios.add(new Municipio("180","Tlahuapan",21));
            listaMunicipios.add(new Municipio("181","Tlaltenango",21));
            listaMunicipios.add(new Municipio("182","Tlanepantla",21));
            listaMunicipios.add(new Municipio("183","Tlaola",21));
            listaMunicipios.add(new Municipio("184","Tlapacoya",21));
            listaMunicipios.add(new Municipio("185","Tlapanalá",21));
            listaMunicipios.add(new Municipio("186","Tlatlauquitepec",21));
            listaMunicipios.add(new Municipio("187","Tlaxco",21));
            listaMunicipios.add(new Municipio("188","Tochimilco",21));
            listaMunicipios.add(new Municipio("189","Tochtepec",21));
            listaMunicipios.add(new Municipio("190","Totoltepec de Guerrero",21));
            listaMunicipios.add(new Municipio("191","Tulcingo",21));
            listaMunicipios.add(new Municipio("192","Tuzamapan de Galeana",21));
            listaMunicipios.add(new Municipio("193","Tzicatlacoyan",21));
            listaMunicipios.add(new Municipio("194","Venustiano Carranza",21));
            listaMunicipios.add(new Municipio("195","Vicente Guerrero",21));
            listaMunicipios.add(new Municipio("196","Xayacatlán de Bravo",21));
            listaMunicipios.add(new Municipio("197","Xicotepec",21));
            listaMunicipios.add(new Municipio("198","Xicotlán",21));
            listaMunicipios.add(new Municipio("199","Xiutetelco",21));
            listaMunicipios.add(new Municipio("200","Xochiapulco",21));
            listaMunicipios.add(new Municipio("201","Xochiltepec",21));
            listaMunicipios.add(new Municipio("202","Xochitlán de Vicente Suárez",21));
            listaMunicipios.add(new Municipio("203","Xochitlán Todos Santos",21));
            listaMunicipios.add(new Municipio("204","Yaonáhuac",21));
            listaMunicipios.add(new Municipio("205","Yehualtepec",21));
            listaMunicipios.add(new Municipio("206","Zacapala",21));
            listaMunicipios.add(new Municipio("207","Zacapoaxtla",21));
            listaMunicipios.add(new Municipio("208","Zacatlán",21));
            listaMunicipios.add(new Municipio("209","Zapotitlán",21));
            listaMunicipios.add(new Municipio("210","Zapotitlán de Méndez",21));
            listaMunicipios.add(new Municipio("211","Zaragoza",21));
            listaMunicipios.add(new Municipio("212","Zautla",21));
            listaMunicipios.add(new Municipio("213","Zihuateutla",21));
            listaMunicipios.add(new Municipio("214","Zinacatepec",21));
            listaMunicipios.add(new Municipio("215","Zongozotla",21));
            listaMunicipios.add(new Municipio("216","Zoquiapan",21));
            listaMunicipios.add(new Municipio("217","Zoquitlán",21));
            Municipio.saveInTx(listaMunicipios);

        }catch (Exception e){
            Log.getStackTraceString(e);
            return 0;
        }
        return 1;
    }

}
