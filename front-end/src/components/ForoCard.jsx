import { useState } from "react";
import {
  FaRegThumbsUp,
  FaRegThumbsDown,
  FaCommentAlt,
  FaShare,
  FaGift,
  FaEllipsisH,
  FaFlag,
} from "react-icons/fa";

const ForoCard = ({ foro, onLike, onComentar }) => {
  const [menuOpen, setMenuOpen] = useState(false);

  return (
    <div className="bg-[#1a1a1b] border border-[#3a3a3c] rounded-lg px-4 py-4 w-full flex items-start gap-4 min-h-[170px]">
      {/* Contenido izquierdo */}
      <div className="flex-1">
        <div className="text-sm text-gray-400 mb-1">
          <span className="font-semibold text-white">r/{foro.categoria || "general"}</span> • hace {foro.horas || "6 h"}
        </div>

        <h2 className="text-xl font-semibold text-white mb-1">{foro.titulo}</h2>

        {foro.link && (
          <a
            href={foro.link}
            className="text-sm text-blue-400 hover:underline break-all"
            target="_blank"
            rel="noopener noreferrer"
          >
            {foro.link}
          </a>
        )}

        {/* Barra de acciones */}
        <div className="mt-4 flex flex-wrap items-center gap-4 text-sm text-gray-400">
          <button onClick={onLike} className="flex items-center gap-1 hover:text-green-400">
            <FaRegThumbsUp /> {foro.likes ?? 0}
          </button>
          <button className="flex items-center gap-1 hover:text-red-400">
            <FaRegThumbsDown />
          </button>
          <button onClick={onComentar} className="flex items-center gap-1 hover:text-blue-400">
            <FaCommentAlt /> {foro.comentarios ?? 0}
          </button>
          <button className="flex items-center gap-1 hover:text-yellow-300">
            <FaShare /> Compartir
          </button>
          <button className="flex items-center gap-1 hover:text-purple-400">
            <FaGift /> Premiar
          </button>

          {/* Submenú ⋯ */}
          <div className="relative ml-auto">
            <button
              onClick={() => setMenuOpen(!menuOpen)}
              className="hover:text-gray-300"
            >
              <FaEllipsisH />
            </button>

            {menuOpen && (
              <div className="absolute right-0 mt-2 w-56 bg-[#2a2a2b] text-sm text-gray-200 rounded shadow-lg z-10">
                <button
                  className="w-full text-left px-4 py-2 hover:bg-[#3b3b3c] flex items-center gap-2"
                  onClick={() => alert("Enviar comentarios")}
                >
                  📝 Enviar comentarios
                </button>
                <button
                  className="w-full text-left px-4 py-2 hover:bg-[#3b3b3c] flex items-center gap-2"
                  onClick={() => alert("Reportar")}
                >
                  <FaFlag /> Reportar
                </button>
              </div>
            )}
          </div>

          <button className="text-green-400 hover:underline ml-2">Únete</button>
        </div>
      </div>

      {/* Miniatura (si existe) */}
      {foro.imagen && (
        <div className="w-full mt-4 overflow-hidden rounded-lg border border-[#333]">
          <a
            href={foro.imagen}
            target="_blank"
            rel="noopener noreferrer"
            className="block"
          >
            <img
              src={foro.imagen}
              alt="imagen del post"
              className="w-full max-h-[300px] object-contain mx-auto transition-all hover:brightness-110 cursor-zoom-in"
            />
          </a>
        </div>
      )}
    </div>
  );
};

export default ForoCard;
