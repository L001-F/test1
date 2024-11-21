
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mon compte - Université Laval</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
   
    <link rel="stylesheet" href="monCompte.css">
    <link rel="stylesheet" href="profile.css">
</head>
<body>
  <hr class="colored-hr">
  <header>
    <div class="header-container">
        <img src="images/logoUMBB.png" alt="Université Laval Logo" class="logo">
        <h1>monPortail</h1>
        <div class="user-actions">
            <a href="#" class="logout">Se déconnecter</a>
        </div>
    </div>
</header>


<div class="navbar">
    <button class="nav-btn profile-btn active" data-target="profile">  <i class="fas fa-user"></i> Profile</button>
    <button class="nav-btn requests-btn" data-target="requests">  

        <i class="fa-solid fa-file"></i>  Consulter les demandes</button>
    <button class="nav-btn notifications-btn" data-target="notifications">  <i class="fas fa-bell"></i>      Notifications</button>
</div>
    
   
<div class="content">
    <div class="tab-content active" id="profile">
        <section class="profile-section">
            <div class="profile-header">
                <div class="profile-pic">
                    <span class="profile-initials">XX</span>
         
                </div>
                 <h2>Nom , Prenom</h2>
            </div>

            <div class="info-section">
                <div class="info-box">
                    <h3>Renseignements personne</h3>
                    <p><strong>Matricule</strong> XXXXXXXX</p>
                    <p><strong>Date de Naissance:</strong> XXXXXXXX</p>
                    <p><strong>Lieu de Naissance:</strong> XXXXXXXX</p>
                </div>
                <div class="info-box">
                    <h3>Renseignements académiques</h3>
                    <p><strong>Departement:</strong> XXXXXXX</p>
                    <p><strong>Role :</strong> XXXX-XXXX</p>
                    <p><strong>email:</strong> XXXXXXXXX@XXX.com</p>
                </div>
            </div>
        </section>
    </div>


    <div class="tab-content" id="requests">
        <section class="demande">
      
            <div class="search-bar-container">
                <i class="fas fa-search search-icon"></i>
                <input
                    type="text"
                    id="search-bar"
                    placeholder="Rechercher une demande..."
                    class="search-bar"
                />
            </div>
        
            <div class="filters-container">
                <!-- First date selection -->
                <div class="filter">
                    <label for="start-date">Début de période :</label>
                    <input type="date" id="start-date" class="date-picker">
                </div>
        
                <!-- Second date selection -->
                <div class="filter">
                    <label for="end-date">Fin de période :</label>
                    <input type="date" id="end-date" class="date-picker">
                </div>
        
                <!-- Document type selection -->
                <div class="filter">
                    <label for="document-type">Type de document :</label>
                    <select id="document-type" class="dropdown">
                        <option value="toutes">toutes</option>
                        <option value="certificat">Certificat de scolarité</option>
                        <option value="bulletin">Bulletin</option>
                        <option value="releve">Relevé de notes</option>
                        <option value="autre">Autre</option>
                    </select>
                </div>
        
                <!-- Academic year selection -->
                <div class="filter">
                    <label for="academic-year">Année scolaire :</label>
                    <select id="academic-year" class="dropdown">
                        <option value="toutes">toutes</option>
                        <option value="l1">L1</option>
                        <option value="l2">L2</option>
                        <option value="l3">L3</option>
                        <option value="m1">M1</option>
                        <option value="m2">M2</option>
                    </select>
                </div>
            </div>
      
            <div class="expandable-container">
              <button class="toggle-btn" onclick="toggleContent(this)">Document 1 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 1: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p> <a href="demande.html" class="button">suivre</a>
              </div>
      
              <button class="toggle-btn" onclick="toggleContent(this)">Document 2 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 2: Quis ipsum suspendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <button class="toggle-btn" onclick="toggleContent(this)">Document 3 ▼</button>
              <div class="expandable-content">
                  <p>Details about Document 3: Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
          </div>
      
      
        </div>




    </section>

    </div>
    <div class="tab-content" id="notifications">
        <h2>Notifications Section</h2>
        <p>This is the content for the Notifications section.</p>
    </div>


  
    <script src="admin-script.js"></script>
    <script src="script.js"></script>
</body>
</html>