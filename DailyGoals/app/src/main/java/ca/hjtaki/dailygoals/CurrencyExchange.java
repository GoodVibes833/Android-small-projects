package ca.hjtaki.dailygoals;

import java.util.ArrayList;
import java.util.List;

public class CurrencyExchange {

    /**
     * __deprecation_message__ : This API endpoint is deprecated and will stop working on June 1st, 2018. For more information please visit: https://github.com/fixerAPI/fixer#readme
     * base : EUR
     * date : 2018-05-28
     * rates : {"AUD":1.541,"BGN":1.9558,"BRL":4.2953,"CAD":1.5114,"CHF":1.1577,"CNY":7.4508,"CZK":25.731,"DKK":7.4474,"GBP":0.87465,"HKD":9.1354,"HRK":7.395,"HUF":319.42,"IDR":16325,"ILS":4.1573,"INR":78.528,"ISK":123.2,"JPY":127.33,"KRW":1250.8,"MXN":22.765,"MYR":4.6316,"NOK":9.5113,"NZD":1.6756,"PHP":61.112,"PLN":4.3053,"RON":4.636,"RUB":72.632,"SEK":10.237,"SGD":1.5615,"THB":37.272,"TRY":5.3482,"USD":1.1644,"ZAR":14.498}
     */

    private String base;
    private String date;
    private RatesBean rates;

    public List<Currency> getCurrencyList(){
        List<Currency> currencyList = new ArrayList<>();
        currencyList.add(new Currency("AUD(Australian Dollar)",rates.getAUD()));
        currencyList.add(new Currency("BGN(Bulgarian Lev)",rates.getBGN()));
        currencyList.add(new Currency("BRL(Brazilian Real)",rates.getBRL()));
        currencyList.add(new Currency("CAD(Canadian Dollar)",rates.getCAD()));
        currencyList.add(new Currency("CHF(Swiss Franc)",rates.getCHF()));

        currencyList.add(new Currency("CNY(Chinese Yuan)",rates.getCNY()));
        currencyList.add(new Currency("CZK(Czech Koruna)",rates.getCZK()));
        currencyList.add(new Currency("DKK(Danish Krone)",rates.getDKK()));
        currencyList.add(new Currency("GBP(British Pound)",rates.getGBP()));
        currencyList.add(new Currency("HKD(Hong Kong dollar)",rates.getHKD()));

        currencyList.add(new Currency("HRK(Croatian Kuna)",rates.getHRK()));
        currencyList.add(new Currency("HUF(Hungarian Forint)",rates.getHUF()));
        currencyList.add(new Currency("IDR(Indonesian Rupiah)",rates.getIDR()));
        currencyList.add(new Currency("ILS(Israeli Shekel)",rates.getILS()));
        currencyList.add(new Currency("INR(Indian Rupee)",rates.getINR()));

        currencyList.add(new Currency("ISK(Icelandic Krona)",rates.getISK()));
        currencyList.add(new Currency("JPY(Japanese Yen)",rates.getJPY()));
        currencyList.add(new Currency("KRW(South Korean Won)",rates.getKRW()));
        currencyList.add(new Currency("MXN(Mexican Peso)",rates.getMXN()));
        currencyList.add(new Currency("MYR(Malaysian Ringgit)",rates.getMYR()));

        currencyList.add(new Currency("NOK(Norwegian Kron)",rates.getNOK()));
        currencyList.add(new Currency("NZD(New Zealand Dollar)",rates.getNZD()));
        currencyList.add(new Currency("PHP(Philippine Piso)",rates.getPHP()));
        currencyList.add(new Currency("PLN(Polish Zloty)",rates.getPLN()));
        currencyList.add(new Currency("RON(Romanian Leu)",rates.getRON()));

        currencyList.add(new Currency("RUB(Russian Ruble)",rates.getRUB()));
        currencyList.add(new Currency("SEK(Swedish Krona)",rates.getSEK()));
        currencyList.add(new Currency("SGD(Singapore Dollar)",rates.getSGD()));
        currencyList.add(new Currency("THB(Thai Baht)",rates.getTHB()));
        currencyList.add(new Currency("TRY(Turkish Lira)",rates.getTRY()));

        currencyList.add(new Currency("USD(US Dollar)",rates.getUSD()));
        currencyList.add(new Currency("ZAR(South African Rand)",rates.getZAR()));


        return currencyList;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RatesBean getRates() {
        return rates;
    }

    public void setRates(RatesBean rates) {
        this.rates = rates;
    }

    public static class RatesBean {
        /**
         * AUD : 1.541
         * BGN : 1.9558
         * BRL : 4.2953
         * CAD : 1.5114
         * CHF : 1.1577
         * CNY : 7.4508
         * CZK : 25.731
         * DKK : 7.4474
         * GBP : 0.87465
         * HKD : 9.1354
         * HRK : 7.395
         * HUF : 319.42
         * IDR : 16325
         * ILS : 4.1573
         * INR : 78.528
         * ISK : 123.2
         * JPY : 127.33
         * KRW : 1250.8
         * MXN : 22.765
         * MYR : 4.6316
         * NOK : 9.5113
         * NZD : 1.6756
         * PHP : 61.112
         * PLN : 4.3053
         * RON : 4.636
         * RUB : 72.632
         * SEK : 10.237
         * SGD : 1.5615
         * THB : 37.272
         * TRY : 5.3482
         * USD : 1.1644
         * ZAR : 14.498
         */

        private double AUD;
        private double BGN;
        private double BRL;
        private double CAD;
        private double CHF;
        private double CNY;
        private double CZK;
        private double DKK;
        private double GBP;
        private double HKD;
        private double HRK;
        private double HUF;
        private int IDR;
        private double ILS;
        private double INR;
        private double ISK;
        private double JPY;
        private double KRW;
        private double MXN;
        private double MYR;
        private double NOK;
        private double NZD;
        private double PHP;
        private double PLN;
        private double RON;
        private double RUB;
        private double SEK;
        private double SGD;
        private double THB;
        private double TRY;
        private double USD;
        private double ZAR;

        public double getAUD() {
            return AUD;
        }

        public void setAUD(double AUD) {
            this.AUD = AUD;
        }

        public double getBGN() {
            return BGN;
        }

        public void setBGN(double BGN) {
            this.BGN = BGN;
        }

        public double getBRL() {
            return BRL;
        }

        public void setBRL(double BRL) {
            this.BRL = BRL;
        }

        public double getCAD() {
            return CAD;
        }

        public void setCAD(double CAD) {
            this.CAD = CAD;
        }

        public double getCHF() {
            return CHF;
        }

        public void setCHF(double CHF) {
            this.CHF = CHF;
        }

        public double getCNY() {
            return CNY;
        }

        public void setCNY(double CNY) {
            this.CNY = CNY;
        }

        public double getCZK() {
            return CZK;
        }

        public void setCZK(double CZK) {
            this.CZK = CZK;
        }

        public double getDKK() {
            return DKK;
        }

        public void setDKK(double DKK) {
            this.DKK = DKK;
        }

        public double getGBP() {
            return GBP;
        }

        public void setGBP(double GBP) {
            this.GBP = GBP;
        }

        public double getHKD() {
            return HKD;
        }

        public void setHKD(double HKD) {
            this.HKD = HKD;
        }

        public double getHRK() {
            return HRK;
        }

        public void setHRK(double HRK) {
            this.HRK = HRK;
        }

        public double getHUF() {
            return HUF;
        }

        public void setHUF(double HUF) {
            this.HUF = HUF;
        }

        public int getIDR() {
            return IDR;
        }

        public void setIDR(int IDR) {
            this.IDR = IDR;
        }

        public double getILS() {
            return ILS;
        }

        public void setILS(double ILS) {
            this.ILS = ILS;
        }

        public double getINR() {
            return INR;
        }

        public void setINR(double INR) {
            this.INR = INR;
        }

        public double getISK() {
            return ISK;
        }

        public void setISK(double ISK) {
            this.ISK = ISK;
        }

        public double getJPY() {
            return JPY;
        }

        public void setJPY(double JPY) {
            this.JPY = JPY;
        }

        public double getKRW() {
            return KRW;
        }

        public void setKRW(double KRW) {
            this.KRW = KRW;
        }

        public double getMXN() {
            return MXN;
        }

        public void setMXN(double MXN) {
            this.MXN = MXN;
        }

        public double getMYR() {
            return MYR;
        }

        public void setMYR(double MYR) {
            this.MYR = MYR;
        }

        public double getNOK() {
            return NOK;
        }

        public void setNOK(double NOK) {
            this.NOK = NOK;
        }

        public double getNZD() {
            return NZD;
        }

        public void setNZD(double NZD) {
            this.NZD = NZD;
        }

        public double getPHP() {
            return PHP;
        }

        public void setPHP(double PHP) {
            this.PHP = PHP;
        }

        public double getPLN() {
            return PLN;
        }

        public void setPLN(double PLN) {
            this.PLN = PLN;
        }

        public double getRON() {
            return RON;
        }

        public void setRON(double RON) {
            this.RON = RON;
        }

        public double getRUB() {
            return RUB;
        }

        public void setRUB(double RUB) {
            this.RUB = RUB;
        }

        public double getSEK() {
            return SEK;
        }

        public void setSEK(double SEK) {
            this.SEK = SEK;
        }

        public double getSGD() {
            return SGD;
        }

        public void setSGD(double SGD) {
            this.SGD = SGD;
        }

        public double getTHB() {
            return THB;
        }

        public void setTHB(double THB) {
            this.THB = THB;
        }

        public double getTRY() {
            return TRY;
        }

        public void setTRY(double TRY) {
            this.TRY = TRY;
        }

        public double getUSD() {
            return USD;
        }

        public void setUSD(double USD) {
            this.USD = USD;
        }

        public double getZAR() {
            return ZAR;
        }

        public void setZAR(double ZAR) {
            this.ZAR = ZAR;
        }
    }
}
