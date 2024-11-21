<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mon portail etudiant</title>
    <link rel="stylesheet" href="etudiant.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <header>
        <div class="header-container">
            <img src="images/logoUMBB.png" alt="Université Laval Logo" class="logo">
            <h1>monPortail</h1>
            <div class="user-actions">
                <span class="user-name">AC</span>
                <a href="#" class="logout">Se déconnecter</a>
            </div>
        </div>
    </header>
     <!--navigation---->
     <div class="navbar">
          <button class="nav-btn profile-btn active" data-target="profile"> <i class="fas fa-user"></i> Profile</button>
          <button class="nav-btn requests-btn" data-target="requests"> <i class="fa-solid fa-file"></i>  Dépodser une  demande</button>
          <button class="nav-btn previous-requests-btn" data-target="privious requests"> <i class="fa-solid fa-file"></i>  Demandes déposées</button>
          <button class="nav-btn notifications-btn" data-target="notifications">  <i class="fas fa-bell"></i>      Notifications</button>
    </div>
    
    <!-- profil section-->
    <div class="content ">
        <div  class="tab-content active "id="profile">
            <section class="profile-section">
             <div class="profile-header">
                   <div class="profile-pic">
                     <span class="profile-initials">LB</span>
                   </div>
                   <h2>Nom , Prenom</h2>
                   
                </div>

            <div class="info-section">
                <div class="info-box">
                    <h3>Renseignements personnels</h3>
                    <p><strong>Date de naissance :</strong> XX/XX/XXXX</p>
                    <p><strong>Lieu de naissance :</strong> XXXXXXXXXXXX</p>
                    <p><strong>e-mail:</strong> XXXXXXX@gmail.com</p>
                </div>
                <div class="info-box">
                    <h3>Renseignements academique </h3>
                    <p><strong>Matricule:</strong> 21213108</p>
                    <p><strong>Département :</strong> Informatique</p>
                    
                </div>
            </div>
         </section>
        </div>

        <!-- "Déposer une demande" Section -->
        <?php
        include('connection-etudiant/dbconnection.php');
        if (isset($_POST['submit'])){
            $matricule = $_POST['matricule'];
            $nom = $_POST['nom'];
            $prenom = $_POST['prenom'];
            $document_type = $_POST['document_type'];
            $specialite = $_POST['specialite'];
            $niveau = $_POST['niveau'];
            $urgence = $_POST['urgence'];


            $query = mysqli_query($conn,"INSERT INTO demandes (matricule,nom,prenom,document_type,specialite,niveau,urgence) VALUES('$matricule','$nom','$prenom','$document_type','$specialite','$niveau','$urgence')");

            if ($query) {
               echo "<script>alert('data insrted succsecfuly')</script>";
            }else {
                echo "<script>alert('error')</script>";
            }
        }
        
        ?>
<div class="tab-content" id="requests">
    <div class="form-section">
        <h2>Demande de Document</h2>
        <form method="POST">
            <!-- Student ID -->
            <div class="form-group">
                <label >Matricule <span class="required">*</span></label>
                <input type="text" id="student_id" name="matricule" placeholder="Votre Marticule" required>
            </div>

            <!-- Student first Name -->
            <div class="form-group">
                <label >Nom <span class="required">*</span></label>
                <input type="text" id="student_name" name="nom" placeholder="Votre nom complet" required>
            </div>
             <!-- Student last Name -->
             <div class="form-group">
                <label >Prenom <span class="required">*</span></label>
                <input type="text" id="student_name" name="prenom" placeholder="Votre nom complet" required>
            </div>

            <!-- Student Name -->
            <div class="form-group">
                <label >L'annee schoolaire <span class="required">*</span></label>
                <input type="text" id="student_name" name="niveau" placeholder="Annee" required>
            </div>

            <!-- Student Name -->
            <div class="form-group">
                <label for="specialite">Specialite<span class="required">*</span></label>
                <select id="specialite" name="specialite" required>
                    <option value="" disabled selected>Choisissez une specialite</option>
                    <option value="l1">L1</option>
                    <option value="l2">L2</option>
                    <option value="l3-isil">L3-ISIL</option>
                    <option value="l3-si">L3-SI</option>
                    <option value="m1">M1</option>
                    <option value="m2">M2</option>
                </select>
            </div>

            <!-- Document Type -->
            <div class="form-group">
                <label for="document_type">Type de Document <span class="required">*</span></label>
                <select id="document_type" name="document_type" required>
                        <option value="" disabled selected>Choisissez un document</option>
                        <option value="Certificat de scolarité">Certificat de scolarité</option>
                        <option value="Attestation de bonne conduite">Attestation de bonne conduite</option>
                        <option value="Relevé de notes">Relevé de notes</option>
                        <option value="Autres">Autres</option>
               </select>
            </div>

            <!-- Textarea for "Autres" option -->
             <div class="form-group" id="autres-reason-group" style="display: none;">
                  <label for="autres_reason">Veuillez préciser :</label>
                  <textarea id="autres_reason" name="document_type" rows="4" placeholder="Décrivez votre demande ici..."></textarea>
             </div>

            <!-- Urgent Section -->
            <div class="urgent-section">
                <label class="urgent-label">
                    <input type="checkbox" class="urgent-checkbox" name="urgent" id="urgent">
                    Cocher si urgent
                </label>
                <div class="urgent-reason" style="display: none;">
                    <textarea name="urgence" id="urgent_reason" placeholder="Raison de l'urgence (optionnel)"></textarea>
                </div>
            </div>

            <!-- Submit Button -->
            <button type="submit" class="submit-btn" name="submit">Soumettre</button>
        </form>
    </div>
</div>
















    <script>
        // changement de section
       document.addEventListener('DOMContentLoaded', () => {
       const buttons = document.querySelectorAll('.nav-btn');
       const tabs = document.querySelectorAll('.tab-content');
   

        buttons.forEach(button => {
        button.addEventListener('click', () => {
            // Remove active class from all buttons and tabs
            buttons.forEach(btn => btn.classList.remove('active'));
            tabs.forEach(tab => tab.classList.remove('active'));

            // Add active class to the clicked button
            button.classList.add('active');

            // Show the corresponding tab content
            const target = button.getAttribute('data-target');
            document.getElementById(target).classList.add('active');
        });
     });
     });
 
    document.addEventListener('DOMContentLoaded', () => {
        const urgentCheckbox = document.getElementById('urgent');
        const urgentReason = document.getElementById('urgent_reason').closest('.urgent-reason');

        urgentCheckbox.addEventListener('change', () => {
            urgentReason.style.display = urgentCheckbox.checked ? 'block' : 'none';
        });
    });

    document.getElementById('document_type').addEventListener('change', function() {
        const autresReasonGroup = document.getElementById('autres-reason-group');
        const documentType = this.value;

        if (documentType === 'Autres') {
            autresReasonGroup.style.display = 'block';  // Show the textarea when 'Autres' is selected
        } else {
            autresReasonGroup.style.display = 'none';   // Hide the textarea for other selections
        }
    });

        
        
       
      
    </script>
</body>
</html>