import ForoCard from "../components/ForoCard";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";

const forosMock = [
  { id: 1, titulo: "¡Bienvenidos al foro!", descripcion: "Presentaciones y reglas del sitio." },
  { id: 2, titulo: "¿Cuál es tu anime favorito?", descripcion: "Debate abierto sobre anime." },
  { id: 3, titulo: "Sugerencias para el sitio", descripcion: "Deja tus ideas aquí." },
];

const Home = () => {
  const handleLike = () => {
    alert("Debes iniciar sesión para dar like.");
  };

  const handleDislike = () => {
    alert("Debes iniciar sesión para dar like.");
  };

  const handleComentar = () => {
    alert("Debes iniciar sesión para comentar.");
  };

  return (
    <div className="min-h-screen flex flex-col bg-[#1a1a1b] text-white transition-colors">
      <Navbar />
      <main className="flex-1 px-4 py-6 max-w-3xl mx-auto space-y-6">
        {forosMock.map((foro) => (
          <ForoCard
            key={foro.id}
            foro={foro}
            onLike={handleLike}
            onDislike={handleDislike}
            onComentar={handleComentar}
          />
        ))}
      </main>
      <Footer />
    </div>
  );
};

export default Home;
