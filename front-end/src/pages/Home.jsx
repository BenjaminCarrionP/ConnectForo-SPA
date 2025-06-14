import Navbar from "../components/Navbar";
import ForoCard from "../components/ForoCard";
import Sidebar from "../components/Sidebar";

const forosMock = [
  {
    id: 1,
    titulo: "¡Bienvenidos al foro!",
    categoria: "connectforo",
    horas: "3 h",
    link: "https://www.connectforo.cl/reglas",
    likes: 46,
    comentarios: 130,
  },
  {
    id: 2,
    titulo: "¿Cuál es tu anime favorito?",
    categoria: "anime",
    horas: "4 h",
    link: "https://www.connectforo.cl/anime",
    likes: 79,
    comentarios: 152,
    imagen: "https://i.imgur.com/MPNfUCA.jpeg",
  },
  {
    id: 3,
    titulo: "Sugerencias para el sitio",
    categoria: "feedback",
    horas: "5 h",
    link: "https://www.connectforo.cl/sugerencias",
    likes: 7,
    comentarios: 71,
  },
  {
    id: 4,
    titulo: "Nuevo evento en la comunidad",
    categoria: "eventos",
    horas: "2 h",
    link: "https://connectforo.cl/eventos",
    likes: 64,
    comentarios: 30,
    imagen: "https://i.imgur.com/zYIlgBl.jpeg",
  },
  {
    id: 5,
    titulo: "Guía para nuevos usuarios",
    categoria: "tutoriales",
    horas: "1 h",
    link: "https://connectforo.cl/guia",
    likes: 33,
    comentarios: 11,
  },
  {
    id: 6,
    titulo: "Mira esta noticia impresionante",
    categoria: "noticias",
    horas: "30 min",
    link: "https://www.latercera.com/noticia-impresionante",
    likes: 121,
    comentarios: 84,
    imagen: "https://i.imgur.com/Nv3V1sc.jpeg",
  },
];

const Home = () => {
  const handleLike = () => alert("Debes iniciar sesión para dar like.");
  const handleComentar = () => alert("Debes iniciar sesión para comentar.");

  return (
    <div className="h-screen flex flex-col bg-[#1a1a1b] text-white overflow-hidden">
      <Navbar />

      <div className="flex-1 grid grid-cols-1 lg:grid-cols-[260px_1fr_320px] w-full h-full">
        {/* Sidebar izquierda */}
        <Sidebar />

        {/* Centro: publicaciones con scroll oculto */}
        <main className="overflow-y-auto px-4 py-6 space-y-6 h-full no-scrollbar">
          {forosMock.map((foro) => (
            <ForoCard
              key={foro.id}
              foro={foro}
              onLike={handleLike}
              onComentar={handleComentar}
            />
          ))}
        </main>

        {/* Sidebar derecha */}
        <aside className="hidden lg:flex flex-col px-4 py-6 sticky top-0 h-screen text-sm text-gray-200 bg-[#1a1a1b] border-l border-[#2d2d2d]">
          <div className="bg-[#262626] rounded-lg p-4 mb-6">
            <h2 className="text-base font-semibold mb-3">Comunidades populares</h2>
            <ul className="space-y-2">
              <li>🔥 Anime</li>
              <li>🏋️ Fitness</li>
              <li>🎲 Juegos de rol</li>
              <li>🎮 Minecraft</li>
              <li>📷 Fotografía</li>
              <li className="text-green-400 cursor-pointer mt-2">Ver más</li>
            </ul>
          </div>

          <div className="mt-auto text-xs text-gray-400 space-y-1 pr-4 mb-6">
            <p className="hover:underline cursor-pointer">Reglas de ConnectForo</p>
            <p className="hover:underline cursor-pointer">Política de privacidad</p>
            <p className="hover:underline cursor-pointer">Acuerdo de usuario</p>
            <p className="mt-2">© 2025 ConnectForo</p>
          </div>
        </aside>
      </div>
    </div>
  );
};

export default Home;
