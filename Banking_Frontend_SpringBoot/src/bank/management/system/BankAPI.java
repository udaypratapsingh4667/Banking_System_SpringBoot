package bank.management.system;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAPI {

    // Hmare Backend ka Address
    // ye sb memory m bhut bde hote h iseeliye static lete h taaki ek hee memory allote ho ek class m
    private static final String BASE_URL = "http://localhost:8080/api/accounts";

    private static final Gson gson = new Gson();
    private static final HttpClient client = HttpClient.newHttpClient();

    // Ye variable yaad rakhega ki kaunsa user logged-in hai (Deposit/Withdraw ke liye zaroori hai)
    public static Long currentUserId = null;

    // 1. Login API Call
    public static boolean login(String cardNumber, String pin) {
        try {
            // 1. Data ko Map mein rakho
            Map<String, String> data = new HashMap<>();
            data.put("cardNumber", cardNumber);
            data.put("pin", pin);

            // 2. Map ko JSON string banao
            String jsonBody = gson.toJson(data);

            // 3. Request build karo (POST to /api/accounts/login)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            // 4. Send karo aur Result lo (HttpResponse.BodyHandlers.ofString() -> Jawaab ko JSON/Text ki tarah padhna)
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Login Success! ID nikalo aur save kar lo
                Map map = gson.fromJson(response.body(), Map.class);
                currentUserId = ((Number) map.get("id")).longValue(); // ID Save ho gayi
                return true; // Login Pass
            } else {
                return false; // Login Fail
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 2. DEPOSIT API Call
    public static boolean deposit(double amount) {
        try {
            // Agar ID nahi hai (Login nahi kiya), toh rok do
            if (currentUserId == null) return false;

            Map<String, Double> data = new HashMap<>();
            data.put("amount", amount);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/" + currentUserId + "/deposit"))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(data)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() == 200;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 3. WITHDRAW API Call
    public static boolean withdraw(double amount) {
        try {
            if (currentUserId == null) return false;

            Map<String, Double> data = new HashMap<>();
            data.put("amount", amount);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/" + currentUserId + "/withdraw"))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(data)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() == 200;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 4. GET BALANCE API Call
    public static double getBalance() {
        try {
            if (currentUserId == null) return 0.0;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/" + currentUserId)) // GET request to /api/accounts/{id}
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Map map = gson.fromJson(response.body(), Map.class);
                return ((Number) map.get("balance")).doubleValue();
            }
            return 0.0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    // --- 4.1. GET CARD NUMBER API Call (Add this method after getBalance() or at the end) ---
    public static String getCardNumber() {
        try {
            if (currentUserId == null) return "N/A";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/" + currentUserId)) // GET request to /api/accounts/{id}
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Map map = gson.fromJson(response.body(), Map.class);

                // Assuming the Card Number is returned as 'cardNumber' in the JSON from backend
                String cardNumber = (String) map.get("cardNumber");

                // For security, you might want to mask part of the number (e.g., ****-****-1234)
                if (cardNumber != null && cardNumber.length() > 4) {
                    return "XXXX-XXXX-" + cardNumber.substring(cardNumber.length() - 4);
                }
                return cardNumber;
            }
            return "N/A";
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }

    // 5. GET Pin API Call
    public static boolean changePin(String newPin) {
        try {
            if (currentUserId == null) return false;

            Map<String ,String> data = new HashMap<>();
            data.put("pin", newPin);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/" + currentUserId + "/pin"))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(data)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.statusCode() == 200;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // helper class for Transaction
    public static class TransactionDetail {
        public String timestamp; // To store the date and time of transaction
        public String transactionType;         // To store "DEPOSIT" or "WITHDRAW"
        public double amount;       // To store the transaction amount
    }

    // 6. GET MINI STATEMENT (Transaction History)
    public static List<TransactionDetail> getMiniStatement() {
        try {
            if (currentUserId == null) return Collections.emptyList();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/" + currentUserId + "/transactions"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Type typeOfList = new TypeToken<List<TransactionDetail>>(){}.getType();
                return gson.fromJson(response.body(), typeOfList);
            }
            return Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    // 7. SIGNUP PAGE 1 API Call
    public static boolean signup1(String formno, String name, String fname, String dob, String gender, String email, String marital, String address, String city, String pincode, String state) {
        try {
            Map<String, String> data = new HashMap<>();
            data.put("formNo", formno);
            data.put("name", name);
            data.put("fatherName", fname);
            data.put("dob", dob);
            data.put("gender", gender);
            data.put("email", email);
            data.put("maritalStatus", marital);
            data.put("address", address);
            data.put("city", city);
            data.put("pinCode", pincode);
            data.put("state", state);

            // POST Request to /api/accounts/signup/1
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/signup/1"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(data)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Agar 200 OK aaya, matlab Data save ho gaya
            return response.statusCode() == 200;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 8. SIGNUP PAGE 2 API Call
    public static boolean signup2(String formno, String religion, String category, String income, String education, String occupation, String pan, String aadhar, String senior, String existing) {
        try {
            Map<String, String> data = new HashMap<>();
            // Keys wahi honi chahiye jo Backend Customer.java mein hain
            data.put("religion", religion);
            data.put("category", category);
            data.put("income", income);
            data.put("education", education);
            data.put("occupation", occupation);
            data.put("panNumber", pan);
            data.put("aadharNumber", aadhar);
            data.put("seniorCitizen", senior);
            data.put("existingAccount", existing);

            // PUT Request to /api/accounts/signup/2/{formNo}
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/signup/2/" + formno))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(data)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.statusCode() == 200;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 9. SIGNUP PAGE 3 (CREATE ACCOUNT)
    public static boolean createAccount(String formno, String accountType, String cardNo, String pin, String services) {
        try {
            // Yeh final step hai jahan Account banta hai
            Map<String, Object> data = new HashMap<>();
            data.put("cardNumber", cardNo);
            data.put("pin", pin);
            data.put("balance", 0.0);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL)) // POST to /api/accounts
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(data)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Map map = gson.fromJson(response.body(), Map.class);
                currentUserId = ((Number) map.get("id")).longValue();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}