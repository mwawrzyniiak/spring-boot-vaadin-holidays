package pl.wawrzyniak.holidays.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.wawrzyniak.holidays.client.HolidaysClient;
import pl.wawrzyniak.holidays.model.CountryEnum;
import pl.wawrzyniak.holidays.model.Holiday;

@Route("holidays")
@StyleSheet("/style.css")
public class HolidaysGui extends VerticalLayout {

    public HolidaysGui() {
        TextField textFieldYear = new TextField("YEAR");
        ComboBox<CountryEnum> comboBoxCountryCode = new ComboBox<>("COUNTRY CODE: ", CountryEnum.values());
        Button buttonAccept = new Button("Accept");

        buttonAccept.addClickListener(click -> {
            removeAll();
            add(textFieldYear, comboBoxCountryCode, buttonAccept);
            HolidaysClient holidaysClient = new HolidaysClient();
            Holiday[] holidays = holidaysClient.getHolidays(textFieldYear.getValue(), comboBoxCountryCode.getValue().toString());

            Grid<Holiday> grid = new Grid<>(Holiday.class);
            grid.setItems(holidays);
            grid.removeColumnByKey("fixed");
            grid.removeColumnByKey("counties");
            grid.removeColumnByKey("launchYear");
            grid.removeColumnByKey("type");
            add(grid);
        });

        add(textFieldYear, comboBoxCountryCode, buttonAccept);
    }

}
