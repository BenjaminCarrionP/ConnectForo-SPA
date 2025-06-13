const ForoCard = ({ foro, onLike, onDislike, onComentar }) => {
  return (
    <div className="bg-[#262626] rounded-lg p-5 shadow hover:shadow-md transition">
      <h2 className="text-xl font-semibold text-white mb-1">{foro.titulo}</h2>
      <p className="text-sm text-gray-300">{foro.descripcion}</p>
      <div className="mt-4 flex items-center space-x-4 text-sm text-gray-400">
        <button onClick={onLike} className="hover:text-green-400 transition">
          ↑
        </button>
        <button onClick={onDislike} className="hover:text-green-400 transition">
          ↓
        </button>
        <button onClick={onComentar} className="hover:text-green-400 transition">
          💬 Comentar
        </button>
      </div>
    </div>
  );
};

export default ForoCard;
