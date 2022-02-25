package db.prescriptions.assignment.Service.FakerData;

import com.github.javafaker.Faker;
import db.prescriptions.assignment.Model.Medicine;
import db.prescriptions.assignment.Repository.MedicineRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakerMedicine {

    public List<Medicine> createFakeMedicine(MedicineRepository medicineRepository) {
        List<Medicine> medicineList = new ArrayList<>();
        medicineList.add(new Medicine("Abilify", 20, "stk.", "Abilify® er et middel mod psykoser."));
        medicineList.add(new Medicine("Actilyse", 10, "stk.", "Actilyse® er et middel til opløsning af blodpropper."));
        medicineList.add(new Medicine("Benylan", 10, "stk.", "Benylan® er et hostestillende middel. Antihistamin."));
        medicineList.add(new Medicine("Campral", 250, "ml.", "Campral® er et middel mod alkoholmisbrug."));
        medicineList.add(new Medicine("Desferal", 20, "stk.", "Desferal® er et middel mod jernforgiftning."));
        medicineList.add(new Medicine("Dermovat", 10, "stk.", "Dermovat® er et meget stærktvirkende hudmiddel med binyrebarkhormon."));
        medicineList.add(new Medicine("Eldepryl", 50, "stk.", "Eldepryl® er et middel mod Parkinsons sygdom. Selektiv MAO-hæmmer."));
        medicineList.add(new Medicine("Letrozol", 100, "ml.", "Femar® er et middel mod brystkræft (antiøstrogen)."));
        medicineList.add(new Medicine("Gabapenstad", 50, "stk.", "Gabapenstad er et middel mod epilepsi."));
        medicineList.add(new Medicine("Haldid", 6, "stk.", "Haldid® er et smertestillende middel til anvendelse ved fuld bedøvelse."));
        medicineList.add(new Medicine("Hjerdyl", 20, "stk.", "Hjerdyl® er et blodpladehæmmende middel."));
        medicineList.add(new Medicine("Ibumetin", 30, "stk.", "Ibumetin® er et middel mod gigt og smerter. NSAID."));
        medicineList.add(new Medicine("Januvia", 10, "stk.", "Januvia® er et middel mod diabetes 2."));
        medicineList.add(new Medicine("Kyntheum", 100, "ml.", "Kyntheum® er et biologisk lægemiddel (immunundertrykkende) mod psoriasis."));
        medicineList.add(new Medicine("Lacipil", 50, "stk.", "Lacipil® er et middel mod forhøjet blodtryk. Calcium-blokker."));
        medicineList.add(new Medicine("Mabthera", 10, "stk.", "Mabthera® er et biologisk middel (immunundertrykkende) mod leddegigt, leukæmi og lymfeknudekræft.Middel til immunterapi (antistof)."));
        medicineList.add(new Medicine("Nasonex", 50, "ml.", "Nasonex® er et middel mod høfeber og næsepolypper. Binyrebarkhormon til brug i næsen."));
        medicineList.add(new Medicine("Olbetam", 20, "stk.", "Olbetam® er et kolesterolsænkende middel. Nicotinsyre og analoger."));
        medicineList.add(new Medicine("Pancillin", 20, "stk.", "Pancillin® er et antibiotikum. Smalspektret penicilin."));
        medicineList.add(new Medicine("Questran", 10, "stk.", "Questran® er et kolesterolsænkende middel. Anionbytter."));
        medicineList.add(new Medicine("Rasilez", 50, "stk.", "Rasilez® er et middel mod forhøjet blodtryk. Reninhæmmer."));
        medicineList.add(new Medicine("Sandomigrin", 50, "stk.", "Sandomigrin® er et middel mod migræne."));
        medicineList.add(new Medicine("Tramadol", 20, "stk.", "Tramadol (Aurobindo) er et smertestillende middel."));
        medicineList.add(new Medicine("Ulcerex", 10, "ml.", "Ulcerex® er et middel mod mavesår. Syrepumpehæmmer."));
        medicineList.add(new Medicine("Vagifem", 20, "stk.", "Vagifem® er et østrogen-præparat til lokalbehandling i skeden."));
        medicineList.add(new Medicine("Wilzin", 10, "stk.", "Wilzin® er et middel mod Wilsons sygdom."));
        medicineList.add(new Medicine("Xagrid", 10, "stk.", "Xagrid® er et celledræbende middel."));
        medicineList.add(new Medicine("Yentreve", 100, "ml.", "Yentreve® er et middel mod ufrivillig vandladning."));
        medicineList.add(new Medicine("Zaditen", 10, "stk.", "Zaditen® er et øjenmiddel mod allergi. Antihistamin."));
        try {
            medicineRepository.saveAll(medicineList);
            System.out.println("Medicine created.");
            return medicineList;
        } catch (Exception e) {
            if (e.getClass().toString().contains("DataIntegrityViolationException")) {
                DataIntegrityViolationException dive = (DataIntegrityViolationException) e;
                System.out.println(dive.getMostSpecificCause());
                return new ArrayList<Medicine>();
            }
        }
        return new ArrayList<Medicine>();
    }
}
