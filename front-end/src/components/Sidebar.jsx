import {
  FaHome,
  FaGamepad,
  FaTv,
  FaGlobe,
  FaMobileAlt,
  FaBrain,
  FaBullhorn,
  FaFileAlt,
  FaEnvelopeOpenText,
} from "react-icons/fa";

const Sidebar = () => {
  return (
    <aside className="hidden lg:block px-4 pt-6 text-sm text-gray-300 space-y-6 h-full border-r border-[#2d2d2d] w-full">
      {/* Logo o título */}
      <div className="font-bold text-lg text-white mb-2">ConnectForo</div>

      {/* Sección: Inicio */}
      <div className="space-y-2">
        <h2 className="text-xs text-gray-500 uppercase tracking-wide">Inicio</h2>
        <ul className="space-y-1">
          <li className="flex items-center gap-2 hover:text-white cursor-pointer">
            <FaHome /> Inicio
          </li>
        </ul>
      </div>

      {/* Sección: Temas */}
      <div className="space-y-2">
        <h2 className="text-xs text-gray-500 uppercase tracking-wide">Temas</h2>
        <ul className="space-y-1">
          <li className="flex items-center gap-2 hover:text-white cursor-pointer">
            <FaGamepad /> Juegos
          </li>
          <li className="flex items-center gap-2 hover:text-white cursor-pointer">
            <FaTv /> Películas y TV
          </li>
          <li className="flex items-center gap-2 hover:text-white cursor-pointer">
            <FaGlobe /> Cultura Internet
          </li>
          <li className="flex items-center gap-2 hover:text-white cursor-pointer">
            <FaMobileAlt /> Tecnología
          </li>
          <li className="flex items-center gap-2 hover:text-white cursor-pointer">
            <FaBrain /> Preguntas y Respuestas
          </li>
        </ul>
      </div>

      {/* Sección: Recursos */}
      <div className="space-y-2">
        <h2 className="text-xs text-gray-500 uppercase tracking-wide">Recursos</h2>
        <ul className="space-y-1">
          <li className="flex items-center gap-2 hover:text-white cursor-pointer">
            <FaBullhorn /> Anunciar
          </li>
          <li className="flex items-center gap-2 hover:text-white cursor-pointer">
            <FaFileAlt /> Normas
          </li>
          <li className="flex items-center gap-2 hover:text-white cursor-pointer">
            <FaEnvelopeOpenText /> Contacto
          </li>
        </ul>
      </div>
    </aside>
  );
};

export default Sidebar;
